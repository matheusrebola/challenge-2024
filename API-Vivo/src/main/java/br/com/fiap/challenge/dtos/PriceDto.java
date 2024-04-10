package br.com.fiap.challenge.dtos;


import br.com.fiap.challenge.entities.Amount;
import br.com.fiap.challenge.entities.PriceType;

public record PriceDto(
        String description,
        PriceType type,
        String recurringPeriod,
        Amount amount
) {
}
