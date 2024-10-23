package challenge.vivo.itemservice.core.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import challenge.vivo.itemservice.core.service.ItemService;
import challenge.vivo.itemservice.core.utils.JsonUtil;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemConsumer {

  private final JsonUtil jsonUtil;
  private final ItemService itemService;

    @KafkaListener(
        groupId = "${spring.kafka.consumer.group-id}",
        topics = "${spring.kafka.topic.item-success}"
    )
    public void consumeSuccessEvent(String payload) {
        log.info("Receiving success event {} from item-success topic", payload);
        var event = jsonUtil.toEvent(payload);
        itemService.validateExistingProducts(event);
    }

    @KafkaListener(
        groupId = "${spring.kafka.consumer.group-id}",
        topics = "${spring.kafka.topic.item-fail}"
    )
    public void consumeFailEvent(String payload) {
        log.info("Receiving rollback event {} from item-fail topic", payload);
        var event = jsonUtil.toEvent(payload);
        itemService.rollbackEvent(event);
    }
}
