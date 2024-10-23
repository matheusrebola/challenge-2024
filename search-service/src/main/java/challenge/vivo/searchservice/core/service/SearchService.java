package challenge.vivo.searchservice.core.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import challenge.vivo.searchservice.config.exception.ValidationException;
import challenge.vivo.searchservice.core.document.Product;
import challenge.vivo.searchservice.core.document.SearchProduct;
import challenge.vivo.searchservice.core.dto.Event;
import challenge.vivo.searchservice.core.dto.History;
import challenge.vivo.searchservice.core.producer.KafkaProducer;
import challenge.vivo.searchservice.core.repository.SearchProductRepository;
import challenge.vivo.searchservice.core.repository.SearchRepository;
import challenge.vivo.searchservice.core.utils.JsonUtil;

import java.time.LocalDateTime;

import static challenge.vivo.searchservice.core.enums.ESagaStatus.*;

@Slf4j
@Service
@AllArgsConstructor
public class SearchService {

    private static final String CURRENT_SOURCE = "INVENTORY_SERVICE";

    private final JsonUtil jsonUtil;
    private final KafkaProducer producer;
    private final SearchRepository searchRepository;
    private final SearchProductRepository searchProductRepository;

    public void updateInventory(Event event) {
        try {
            checkCurrentValidation(event);
            createOrderInventory(event);
            updateInventory(event.getPayload());
            handleSuccess(event);
        } catch (Exception ex) {
            log.error("Error trying to update inventory: ", ex);
            handleFailCurrentNotExecuted(event, ex.getMessage());
        }
        producer.sendEvent(jsonUtil.toJson(event));
    }

    private void checkCurrentValidation(Event event) {
        if (orderInventoryRepository.existsByOrderIdAndTransactionId(
            event.getPayload().getId(), event.getTransactionId())) {
            throw new ValidationException("There's another transactionId for this validation.");
        }
    }

    private void createOrderInventory(Event event) {
        event
            .getPayload()
            .getProducts()
            .forEach(product -> {
                var inventory = findInventoryByProductCode(product.getProduct().getCode());
                var orderInventory = createOrderInventory(event, product, inventory);
                orderInventoryRepository.save(orderInventory);
            });
    }

    private SearchProduct createOrderInventory(Event event,
                                                OrderProducts product,
                                                Inventory inventory) {
        return OrderInventory
            .builder()
            .inventory(inventory)
            .oldQuantity(inventory.getAvailable())
            .orderQuantity(product.getQuantity())
            .newQuantity(inventory.getAvailable() - product.getQuantity())
            .orderId(event.getPayload().getId())
            .transactionId(event.getTransactionId())
            .build();
    }

    private void handleSuccess(Event event) {
        event.setStatus(SUCCESS);
        event.setSource(CURRENT_SOURCE);
        addHistory(event, "Inventory updated successfully!");
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

    private void handleFailCurrentNotExecuted(Event event, String message) {
        event.setStatus(ROLLBACK_PENDING);
        event.setSource(CURRENT_SOURCE);
        addHistory(event, "Fail to update inventory: ".concat(message));
    }

    public void rollbackInventory(Event event) {
        event.setStatus(FAIL);
        event.setSource(CURRENT_SOURCE);
        try {
            returnInventoryToPreviousValues(event);
            addHistory(event, "Rollback executed for inventory!");
        } catch (Exception ex) {
            addHistory(event, "Rollback not executed for inventory: ".concat(ex.getMessage()));
        }
        producer.sendEvent(jsonUtil.toJson(event));
    }
}
