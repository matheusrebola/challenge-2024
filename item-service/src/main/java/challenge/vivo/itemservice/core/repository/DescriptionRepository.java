package challenge.vivo.itemservice.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import challenge.vivo.itemservice.core.document.Description;

@Repository
public interface DescriptionRepository extends MongoRepository<Description, String>{

}
