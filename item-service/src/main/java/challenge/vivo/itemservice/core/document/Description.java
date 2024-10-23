package challenge.vivo.itemservice.core.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import challenge.vivo.itemservice.core.document.enums.Category;

@Document
public record Description(
  @Id String id,
  String text,
  String url,
  Category category
) {

}
