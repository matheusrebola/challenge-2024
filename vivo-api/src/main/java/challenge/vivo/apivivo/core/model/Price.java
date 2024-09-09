package challenge.vivo.apivivo.core.model;

import java.util.UUID;

import challenge.vivo.apivivo.core.enum.PriceType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Price(
    @Id @GeneratedValue(strategy = GenerationType.UUID) UUID id,
    Description description,
    PriceType priceType,
    String recurringPeriod
) 
{

}
