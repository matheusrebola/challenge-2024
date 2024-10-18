package challenge.vivo.apivivo.core.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import challenge.vivo.apivivo.core.entities.enums.ProductType;
import challenge.vivo.apivivo.core.entities.enums.SubscriptionType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Product(
    @Id UUID id,
    String productName,
    ProductType productType,
    String descriptionId,  // Referência ao ID do microserviço de descrição
    SubscriptionType subscriptionType,
    List<String> tags,
    List<String> priceIds, // Lista de IDs de preços para este produto
    LocalDateTime lastAccessed 
) {

}
