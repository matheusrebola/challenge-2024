package challenge.vivo.apivivo.core.dto;

import challenge.vivo.apivivo.core.enums.ProductType;
import challenge.vivo.apivivo.core.enums.SubscriptionType;
import challenge.vivo.apivivo.core.model.Description;

public record ProductCreateDto(
    String productName,
    ProductType ProductType,
    Description description,
    SubscriptionType subscriptionType,
    String tags
) {

}
