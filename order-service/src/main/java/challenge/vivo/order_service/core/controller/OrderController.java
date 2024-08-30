package challenge.vivo.order_service.core.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.vivo.order_service.core.document.Order;
import challenge.vivo.order_service.core.dto.OrderRequest;
import challenge.vivo.order_service.core.service.OrderService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

	private OrderService orderService;

    @PostMapping
    public Order create(@RequestBody OrderRequest order) {
        return orderService.createOrder(order);
    }
}
