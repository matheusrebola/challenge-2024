package challenge.vivo.itemservice.core.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import challenge.vivo.itemservice.core.document.Product;
import challenge.vivo.itemservice.core.document.enums.ProductType;
import challenge.vivo.itemservice.core.document.enums.SubscriptionType;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
  Optional<Product> findByProductType(ProductType productType);
  Optional<Product> findBySubscriptionType(SubscriptionType subscriptionType);
  Optional<Product> findTop1BySearchsCounter(Integer searchsCounter);
  Optional<Product> findTop10BySearchsCounter(Integer searchsCounter);
}
