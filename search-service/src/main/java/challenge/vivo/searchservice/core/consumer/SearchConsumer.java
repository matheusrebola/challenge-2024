package challenge.vivo.searchservice.core.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import challenge.vivo.searchservice.core.service.SearchService;
import challenge.vivo.searchservice.core.utils.JsonUtil;

@Slf4j
@Component
@RequiredArgsConstructor
public class SearchConsumer {
  private final SearchService searchService;
  private final JsonUtil jsonUtil;

  @KafkaListener(
    groupId = "${spring.kafka.consumer.group-id}",
    topics = "${spring.kafka.topic.search-success}"
  )
  public void consumeSuccessEvent(String payload) {
    log.info("Receiving success event {} from search-success topic", payload);
  }

  @KafkaListener(
    groupId = "${spring.kafka.consumer.group-id}",
    topics = "${spring.kafka.topic.search-fail}"
  )
  public void consumeFailEvent(String payload) {
    log.info("Receiving rollback event {} from search-fail topic", payload);
  }
}
