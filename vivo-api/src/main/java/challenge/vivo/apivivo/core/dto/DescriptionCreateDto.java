package challenge.vivo.apivivo.core.dto;

import challenge.vivo.apivivo.core.enum.Category;

public record DescriptionCreateDto(
    String text,
	String url,
	Category category
) {

}
