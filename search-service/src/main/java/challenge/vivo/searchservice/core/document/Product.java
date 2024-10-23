package challenge.vivo.searchservice.core.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Product(
  @Id String id,
  String productCode,
  Integer available
) {

}
