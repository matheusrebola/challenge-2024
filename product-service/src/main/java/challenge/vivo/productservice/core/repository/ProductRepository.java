package challenge.vivo.productservice.core.repository;

import challenge.vivo.productservice.core.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    // Encontra produtos cujo campo lastAccessed é anterior à data fornecida
    List<Product> findByLastAccessedBefore(LocalDateTime dateTime);

}
