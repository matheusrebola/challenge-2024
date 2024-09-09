package challenge.vivo.apivivo.core.model;

import java.util.UUID;

import challenge.vivo.apivivo.core.enum.ProductType;
import challenge.vivo.apivivo.core.enum.SubscriptionType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Product(
    @Id @GeneratedValue(strategy = GenerationType.UUID) UUID id,
    String productName,
    ProductType ProductType,
    Description description,
    SubscriptionType subscriptionType,
    String tags
) {

}
