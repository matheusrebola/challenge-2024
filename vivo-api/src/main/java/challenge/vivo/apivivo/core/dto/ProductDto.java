package challenge.vivo.apivivo.core.dto;

import java.util.UUID;
import challenge.vivo.apivivo.core.enums.ProductType;
import challenge.vivo.apivivo.core.enums.SubscriptionType;
import challenge.vivo.apivivo.core.model.Description;

public record ProductDto(
    UUID id,
    String productName,
    ProductType ProductType,
    Description description,
    SubscriptionType subscriptionType,
    String tags
) {

}
