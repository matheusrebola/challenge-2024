package challenge.vivo.priceservice.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import challenge.vivo.priceservice.core.document.Price;

public interface PriceRepository extends MongoRepository<Price, String> {
    
}
