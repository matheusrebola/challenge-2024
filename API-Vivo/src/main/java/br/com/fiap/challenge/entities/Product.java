package br.com.fiap.challenge.entities;

import java.util.List;

public record Product(
        String productName,
        ProductType productType,
        List<Description> descriptions,
        SubscriptionType subscriptionType,
        List<String> tags
)
{

}
