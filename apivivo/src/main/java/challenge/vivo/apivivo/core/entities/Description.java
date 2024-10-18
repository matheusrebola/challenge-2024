package challenge.vivo.apivivo.core.entities;

import java.util.Locale.Category;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Description(
     @Id UUID id,
    String text,
    String url,
    Category category    
) {

}
