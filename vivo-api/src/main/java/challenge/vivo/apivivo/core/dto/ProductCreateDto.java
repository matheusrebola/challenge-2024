package challenge.vivo.apivivo.core.dto;

import challenge.vivo.apivivo.core.enum.ProductType;
import challenge.vivo.apivivo.core.enum.SubscriptionType;
import challenge.vivo.apivivo.core.model.Description;

public record ProductCreateDto(
    String productName,
    ProductType ProductType,
    Description description,
    SubscriptionType subscriptionType,
    String tags
) {

}
