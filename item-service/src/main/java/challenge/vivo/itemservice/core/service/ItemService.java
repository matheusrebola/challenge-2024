package challenge.vivo.itemservice.core.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.stereotype.Service;

import challenge.vivo.itemservice.config.exception.ValidationException;
import challenge.vivo.itemservice.core.document.Validation;
import challenge.vivo.itemservice.core.dto.Event;
import challenge.vivo.itemservice.core.dto.History;
import challenge.vivo.itemservice.core.dto.OrderProducts;
import challenge.vivo.itemservice.core.producer.KafkaProducer;
import challenge.vivo.itemservice.core.repository.ProductRepository;
import challenge.vivo.itemservice.core.repository.ValidationRepository;
import challenge.vivo.itemservice.core.utils.JsonUtil;
import challenge.vivo.itemservice.core.enums.ESagaStatus.*;

import java.time.LocalDateTime;

import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
@Service
@AllArgsConstructor
public class ItemService {
  private static final String CURRENT_SOURCE = "ITEM_SERVICE";

    private final JsonUtil jsonUtil;
    private final KafkaProducer producer;
    private final ProductRepository productRepository;
    private final ValidationRepository validationRepository;

    public void validateExistingProducts(Event event) {
        try {
            checkCurrentValidation(event);
            createValidation(event, true);
            handleSuccess(event);
        } catch (Exception ex) {
            log.error("Error trying to validate product: ", ex);
            handleFailCurrentNotExecuted(event, ex.getMessage());
        }
        producer.sendEvent(jsonUtil.toJson(event));
    }

    private void validateProductsInformed(Event event) {
        if (isEmpty(event.getPayload()) || isEmpty(event.getPayload().getProducts())) {
            throw new ValidationException("Product list is empty!");
        }
        if (isEmpty(event.getPayload().getId()) || isEmpty(event.getTransactionId())) {
            throw new ValidationException("OrderID and TransactionID must be informed!");
        }
    }

    private void checkCurrentValidation(Event event) {
        validateProductsInformed(event);
        if (validationRepository.existsByOrderIdAndTransactionId(
            event.getOrderId(), event.getTransactionId())) {
            throw new ValidationException("There's another transactionId for this validation.");
        }
        event.getPayload().getProducts().forEach(product -> {
            validateProductInformed(product);
            validateExistingProduct(product.getProduct().getCode());
        });
    }

    private void validateProductInformed(OrderProducts product) {
        if (isEmpty(product.getProduct()) || isEmpty(product.getProduct().getCode())) {
            throw new ValidationException("Product must be informed!");
        }
    }

    private void validateExistingProduct(String code) {
        if (!productRepository.existsById(code)) {
            throw new ValidationException("Product does not exists in database!");
        }
    }

    private void createValidation(Event event, boolean success) {
        var validation = Validation
            .builder()
            .orderId(event.getPayload().getId())
            .transactionId(event.getTransactionId())
            .success(success)
            .build();
        validationRepository.save(validation);
    }
    
    private void addHistory(Event event, String message) {
        var history = History
        .builder()
        .source(event.getSource())
        .status(event.getStatus())
        .message(message)
        .createdAt(LocalDateTime.now())
        .build();
        event.addToHistory(history);
    }
    
    private void handleSuccess(Event event) {
        event.setStatus(SUCCESS);
        event.setSource(CURRENT_SOURCE);
        addHistory(event, "Products are validated successfully!");
    }
    
    private void handleFailCurrentNotExecuted(Event event, String message) {
        event.setStatus(ROLLBACK_PENDING);
        event.setSource(CURRENT_SOURCE);
        addHistory(event, "Fail to validate products: ".concat(message));
    }

    public void rollbackEvent(Event event) {
        changeValidationToFail(event);
        event.setStatus(FAIL);
        event.setSource(CURRENT_SOURCE);
        addHistory(event, "Rollback executed on product validation!");
        producer.sendEvent(jsonUtil.toJson(event));
    }

    private void changeValidationToFail(Event event) {
        validationRepository
            .findByOrderIdAndTransactionId(event.getOrderId(), event.getTransactionId())
            .ifPresentOrElse(validation -> {
                    validation.setSuccess(false);
                    validationRepository.save(validation);
                },
                () -> createValidation(event, false));
    }
}
