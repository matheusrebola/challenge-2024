package br.com.fiap.challenge.dtos;

import br.com.fiap.challenge.entities.Description;
import br.com.fiap.challenge.entities.ProductType;
import br.com.fiap.challenge.entities.SubscriptionType;

import java.util.List;

public record ProductDto(
        String productName,
        ProductType productType,
        Description descriptions,
        SubscriptionType subscriptionType,
        String tags
) {
}
