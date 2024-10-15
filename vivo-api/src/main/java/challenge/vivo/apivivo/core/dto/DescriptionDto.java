package challenge.vivo.apivivo.core.dto;
import java.util.UUID;

import challenge.vivo.apivivo.core.enums.Category;

public record DescriptionDto(
    UUID id,
    String text,
	String url,
	Category category
) {

}
