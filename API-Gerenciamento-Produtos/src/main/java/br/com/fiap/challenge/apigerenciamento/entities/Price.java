package br.com.fiap.challenge.apigerenciamento.entities;

public record Price(
        String description,
        PriceType type,
        String recurringPeriod,
        Amount amount
)
{

}
