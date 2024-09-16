package challenge.vivo.priceservice.core.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import challenge.vivo.priceservice.core.enums.PriceType;

@Document(collection = "prices")
public record Price(
    @Id
    String id,
    String descriptionId,  // Referência ao ID do microserviço de descrição
    PriceType priceType,
    String recurringPeriod
) {}
