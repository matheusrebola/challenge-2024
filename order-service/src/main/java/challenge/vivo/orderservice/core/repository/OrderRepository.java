package challenge.vivo.orderservice.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import challenge.vivo.orderservice.core.document.Order;

public interface OrderRepository extends MongoRepository<Order, String>  {

}
