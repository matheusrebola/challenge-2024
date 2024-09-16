package challenge.vivo.apivivo.core.dto;

import challenge.vivo.descriptionservice.core.enums.Category;

public record DescriptionCreateDto(
  String text,
	String url,
	Category category
) {

}
