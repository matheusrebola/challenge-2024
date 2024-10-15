package challenge.vivo.apivivo.core.repository;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import challenge.vivo.apivivo.core.enums.SubscriptionType;
import challenge.vivo.apivivo.core.model.Price;
import challenge.vivo.apivivo.core.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
  public List<Product> findByProductName(String productName);
  public List<Product> findBySubscriptionType(SubscriptionType subscriptionType);
  public List<Product> findByPrice(Price price);
}
