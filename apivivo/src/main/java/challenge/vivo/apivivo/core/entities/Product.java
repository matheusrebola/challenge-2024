package challenge.vivo.apivivo.core.entities;

import java.util.UUID;

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
