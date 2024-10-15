package challenge.vivo.productservice.core.repository;

import challenge.vivo.productservice.core.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    // Encontra produtos cujo campo lastAccessed é anterior à data fornecida
    List<Product> findByLastAccessedBefore(LocalDateTime dateTime);
    Product findByMoreSearchs();
}
