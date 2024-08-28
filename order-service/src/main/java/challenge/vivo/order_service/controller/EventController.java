package challenge.vivo.order_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.vivo.order_service.core.document.Event;
import challenge.vivo.order_service.core.dto.EventFilters;
import challenge.vivo.order_service.core.service.EventService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/event")
public class EventController {

	private final EventService service;

    @GetMapping
    public Event findByFilters(EventFilters filters) {
        return service.findByFilters(filters);
    }

    @GetMapping("all")
    public List<Event> findAll() {
        return service.findAll();
    }
}
