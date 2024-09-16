package challenge.vivo.descriptionservice.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import challenge.vivo.descriptionservice.core.document.Description;

public interface DescriptionRepository extends MongoRepository<Description, String> {
    
}
