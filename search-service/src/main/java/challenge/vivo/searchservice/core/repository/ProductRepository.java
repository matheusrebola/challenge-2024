package challenge.vivo.searchservice.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import challenge.vivo.searchservice.core.document.Product;

public interface ProductRepository extends MongoRepository<Product,String> {
}
