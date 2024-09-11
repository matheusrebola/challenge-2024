package challenge.vivo.apivivo.core.model;

import java.util.UUID;
import challenge.vivo.apivivo.core.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Description(
    @Id @GeneratedValue(strategy = GenerationType.UUID) UUID id,
    String text,
    String url,
    Category category
) {}