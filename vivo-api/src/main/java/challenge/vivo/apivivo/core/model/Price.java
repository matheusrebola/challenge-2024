package challenge.vivo.apivivo.core.model;

import java.util.UUID;
import challenge.vivo.apivivo.core.enums.PriceType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public record Price(
    @Id @GeneratedValue(strategy = GenerationType.UUID) UUID id,
    @ManyToOne // Relacionamento de muitos preços para uma descrição
    Description description,
    PriceType priceType,
    String recurringPeriod,
    @ManyToOne // Muitos preços podem estar associados a um produto
    Product product
) 
{}

