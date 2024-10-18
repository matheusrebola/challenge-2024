package challenge.vivo.apivivo.core.entities;

import java.util.UUID;

import challenge.vivo.apivivo.core.entities.enums.Category;
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
