package challenge.vivo.itemservice.core.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import challenge.vivo.itemservice.core.document.enums.ProductType;
import challenge.vivo.itemservice.core.document.enums.SubscriptionType;

@Document
public record Product(
  @Id String id,
  String productName,
  ProductType productType,
  Description description,
  SubscriptionType subscriptionType,
  Price price,
  String tags,
  Integer searchsCounter
) {

}
