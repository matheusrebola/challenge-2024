package challenge.vivo.descriptionservice.core.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import challenge.vivo.descriptionservice.core.enums.Category;

@Document(collection = "descriptions")
public record Description(
    @Id
    String id,
    String text,
    String url,
    Category category
) {}
