package challenge.vivo.apivivo.core.model;

import java.util.List;
import java.util.UUID;

import challenge.vivo.descriptionservice.core.enums.ProductType;
import challenge.vivo.descriptionservice.core.enums.SubscriptionType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public record Product(
    @Id @GeneratedValue(strategy = GenerationType.UUID) UUID id,
    String productName,
    ProductType ProductType,
    @ManyToOne // Muitos produtos podem compartilhar uma mesma descrição
    Description description,
    SubscriptionType subscriptionType,
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL) // Um produto pode ter vários preços
    List<Price> prices, // Usando uma lista de preços
    @ElementCollection // Para armazenar múltiplas tags como uma lista de strings
    List<String> tags
) {}

