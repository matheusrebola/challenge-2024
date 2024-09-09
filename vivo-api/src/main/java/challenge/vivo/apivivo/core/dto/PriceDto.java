package challenge.vivo.apivivo.core.dto;

import challenge.vivo.apivivo.core.enum.PriceType;
import challenge.vivo.apivivo.core.model.Description;

public record PriceDto(
    Description description,
    PriceType priceType,
    String recurringPeriod
) {

}
