package br.com.fiap.challenge.entities;

public record Price(
        String description,
        PriceType type,
        String recurringPeriod,
        Amount amount
)
{

}
