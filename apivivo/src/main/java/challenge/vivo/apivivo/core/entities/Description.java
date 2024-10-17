package challenge.vivo.apivivo.core.entities;

import java.util.UUID;

@Entity
public record Description(
     @Id
    String id,
    String text,
    String url,
    Category category    
) {

}
