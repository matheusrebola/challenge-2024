package challenge.vivo.order_service.core.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import challenge.vivo.order_service.core.document.Event;
import challenge.vivo.order_service.core.document.Order;
import challenge.vivo.order_service.core.dto.OrderRequest;
import challenge.vivo.order_service.core.producer.SagaProducer;
import challenge.vivo.order_service.core.repository.OrderRepository;
import challenge.vivo.order_service.core.utils.JsonUtil;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService {
  private static final String TRANSACTION_ID_PATTERN = "%s_%s";

    private final EventService eventService;
    private final SagaProducer producer;
    private final JsonUtil jsonUtil;
    private final OrderRepository repository;

    public Order createOrder(OrderRequest orderRequest) {
        var order = Order
            .builder()
            .products(orderRequest.getProducts())
            .createdAt(LocalDateTime.now())
            .transactionId(
                String.format(TRANSACTION_ID_PATTERN, Instant.now().toEpochMilli(), UUID.randomUUID()))
            .build();
        repository.save(order);
        producer.sendEvent(jsonUtil.toJson(createPayload(order)));
        return order;
    }

    private Event createPayload(Order order) {
        var event = Event
            .builder()
            .orderId(order.getId())
            .transactionId(order.getTransactionId())
            .payload(order)
            .createdAt(LocalDateTime.now())
            .build();
        eventService.save(event);
        return event;
    }
}
