package challenge.vivo.itemservice.core.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import challenge.vivo.itemservice.core.document.Validation;

@Repository
public interface ValidationRepository extends MongoRepository<Validation, Integer> {
  Boolean existsByOrderIdAndTransactionId(String orderId, String transactionId);
  Optional<Validation> findByOrderIdAndTransactionId(String orderId, String transactionId);
}
