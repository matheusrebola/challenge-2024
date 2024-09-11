package challenge.vivo.apivivo.core.dto;

import java.util.UUID;
import challenge.vivo.apivivo.core.enums.PriceType;
import challenge.vivo.apivivo.core.model.Description;

public record PriceDto(
    UUID id,
    Description description,
    PriceType priceType,
    String recurringPeriod
) {

}
