package challenge.vivo.order_service.core.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import challenge.vivo.order_service.core.service.EventService;
import challenge.vivo.order_service.core.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class EventConsumer {
	private final EventService service;
    private final JsonUtil jsonUtil;

    @KafkaListener(
        groupId = "${spring.kafka.consumer.group-id}",
        topics = "${spring.kafka.topic.notify-ending}"
    )
    public void consumeNotifyEndingEvent(String payload) {
        log.info("Receiving ending notification event {} from notify-ending topic", payload);
        var event = jsonUtil.toEvent(payload);
        service.notifyEnding(event);
    }
}
