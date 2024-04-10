package br.com.fiap.challenge.dtos;

import br.com.fiap.challenge.entities.DescriptionCategory;

public record DescriptionDto(
        String text,
        String url,
        DescriptionCategory category
) {
}
