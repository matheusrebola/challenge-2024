package challenge.vivo.order_service.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import challenge.vivo.order_service.core.document.Order;

public interface OrderRepository extends MongoRepository<Order, String>  {

}
