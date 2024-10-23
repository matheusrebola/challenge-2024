package challenge.vivo.itemservice.core.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import challenge.vivo.itemservice.core.document.enums.PriceType;

@Document
public record Price(
  @Id String id,
  Description description,
  PriceType priceType,
  String recurringPeriod,
  Product product
) {

}
