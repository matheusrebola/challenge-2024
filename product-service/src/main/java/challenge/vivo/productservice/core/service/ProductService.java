package challenge.vivo.productservice.core.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import challenge.vivo.productservice.config.exception.ValidationException;
import challenge.vivo.productservice.core.dto.Event;
import challenge.vivo.productservice.core.dto.History;
import challenge.vivo.productservice.core.dto.Product;
import challenge.vivo.productservice.core.producer.KafkaProducer;
import challenge.vivo.productservice.core.repository.ProductRepository;
import challenge.vivo.productservice.core.utils.JsonUtils;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private static final String CURRENT_SOURCE = "PAYMENT_SERVICE";
    private static final Double REDUCE_SUM_VALUE = 0.0;
    private static final Double MIN_VALUE_AMOUNT = 0.1;

    private final JsonUtils jsonUtil;
    private final KafkaProducer producer;

    public List<Product> getAllPrices() {
        return productRepository.findAll();
    }

    public Product getPriceById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Description not found"));
    }

    public Product createPrice(Product price) {
        return productRepository.save(price);
    }

    public void deletePrice(String id) {
        productRepository.deleteById(id);
    }    

    private void checkCurrentValidation(Event event) {
        if (productRepository.existsByOrderIdAndTransactionId(event.getPayload().getId(), event.getTransactionId())) {
            throw new ValidationException("There's another transactionId for this validation.");
        }
    }

    private void handleSuccess(Event event) {
        event.setStatus(SUCCESS);
        event.setSource(CURRENT_SOURCE);
        addHistory(event, "Payment realized successfully!");
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
        addHistory(event, "Fail to find product: ".concat(message));
    }


    private Product findByOrderIdAndTransactionId(Event event) {
        return productRepository
            .findByOrderIdAndTransactionId(event.getPayload().getId(), event.getTransactionId())
            .orElseThrow(() -> new ValidationException("Product not found by orderID and transactionID"));
    }

    public void updateProduct(Product product) {
        // Verifica se o produto já existe no MongoDB
        Optional<Product> existingProduct = productRepository.findById(product.id());

        if (existingProduct.isPresent()) {
            // Atualiza o produto existente
            Product updatedProduct = new Product(
                product.id(),
                product.productName(),
                product.productType(),
                product.description(),
                product.subscriptionType(),
                product.tags()
            );
            productRepository.save(updatedProduct);
        } else {
            // Se não existir, salva como um novo documento
            productRepository.save(product);
        }
    }

    public Optional<Product> findProductById(String id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            // Atualiza o campo lastAccessed para a data e hora atual
            Product product = productOptional.get();
            Product updatedProduct = new Product(
                product.id(),
                product.productName(),
                product.productType(),
                product.description(),
                product.subscriptionType(),
                product.tags(),
                LocalDateTime.now()  // Atualiza para a hora atual
            );
            productRepository.save(updatedProduct);
        }

        return productOptional;
    }
}