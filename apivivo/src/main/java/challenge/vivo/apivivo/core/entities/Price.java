package challenge.vivo.apivivo.core.entities;

import java.util.UUID;

import challenge.vivo.apivivo.core.entities.enums.PriceType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Price(
    @Id UUID id,
    String descriptionId,  // Referência ao ID do microserviço de descrição
    PriceType priceType,
    String recurringPeriod
) {

}
