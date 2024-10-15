package challenge.vivo.productservice.core.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

import challenge.vivo.productservice.core.enums.ProductType;
import challenge.vivo.productservice.core.enums.SubscriptionType;

@Document(collection = "products")
public record Product(
    @Id
    String id,
    String productName,
    ProductType productType,
    String descriptionId,  // Referência ao ID do microserviço de descrição
    SubscriptionType subscriptionType,
    List<String> tags,
    List<String> priceIds, // Lista de IDs de preços para este produto
    LocalDateTime lastAccessed,
    Short searchs
) {}
