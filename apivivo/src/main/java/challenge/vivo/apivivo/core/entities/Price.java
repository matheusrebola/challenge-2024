package challenge.vivo.apivivo.core.entities;

import java.util.UUID;

@Entity
public record Price(
    @Id UUID id,
    String descriptionId,  // Referência ao ID do microserviço de descrição
    PriceType priceType,
    String recurringPeriod
) {

}
