package challenge.vivo.apivivo.core.dto;

import java.util.UUID;

import challenge.vivo.apivivo.core.model.Description;
import challenge.vivo.descriptionservice.core.enums.ProductType;
import challenge.vivo.descriptionservice.core.enums.SubscriptionType;

public record ProductDto(
    UUID id,
    String productName,
    ProductType ProductType,
    Description description,
    SubscriptionType subscriptionType,
    String tags
) {

}
