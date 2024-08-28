package challenge.vivo.order_service.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import challenge.vivo.order_service.core.document.Event;

import java.util.List;
import java.util.Optional;


public interface EventRepository extends MongoRepository<Event, String> {

	List<Event> findAllByOrderByCreatedAtDesc();

    Optional<Event> findTop1ByOrderIdOrderByCreatedAtDesc(String orderId);

    Optional<Event> findTop1ByTransactionIdOrderByCreatedAtDesc(String transactionId);
}
