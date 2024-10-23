package challenge.vivo.searchservice.core.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import challenge.vivo.searchservice.core.dto.Event;
import challenge.vivo.searchservice.core.dto.History;
import challenge.vivo.searchservice.core.dto.Order;
import challenge.vivo.searchservice.core.producer.KafkaProducer;
import challenge.vivo.searchservice.core.utils.JsonUtil;

import java.time.LocalDateTime;

import static challenge.vivo.searchservice.core.enums.ESagaStatus.*;

@Slf4j
@Service
@AllArgsConstructor
public class SearchService {
    private static final String CURRENT_SOURCE = "SEARCH_SERVICE";

private final JsonUtil jsonUtil;
private final KafkaProducer producer;

public void updateSearch(Event event) {
    try {
        checkCurrentValidation(event);
        createSearchProduct(event);
        updateSearchData(event.getPayload());
        handleSuccess(event);
    } catch (Exception ex) {
        log.error("Error trying to update search: ", ex);
        handleFailCurrentNotExecuted(event, ex.getMessage());
    }
    producer.sendEvent(jsonUtil.toJson(event));
}

private void checkCurrentValidation(Event event) {

}

private void createSearchProduct(Event event) {

}

private void updateSearchData(Order order) {

}

private void handleSuccess(Event event) {
    event.setStatus(SUCCESS);
    event.setSource(CURRENT_SOURCE);
    addHistory(event, "Search data updated successfully!");
}

private void addHistory(Event event, String message) {
    var history = History
        .builder()
        .source(event.getSource())
        .status(event.getStatus())
        .message(message)
        .createdAt(LocalDateTime.now())
        .build();
    event.addToHistory(history);
}

private void handleFailCurrentNotExecuted(Event event, String message) {
    event.setStatus(ROLLBACK_PENDING);
    event.setSource(CURRENT_SOURCE);
    addHistory(event, "Fail to update search data: ".concat(message));
}

public void rollbackSearch(Event event) {
    event.setStatus(FAIL);
    event.setSource(CURRENT_SOURCE);
    try {
        returnSearchToPreviousValues(event);
        addHistory(event, "Rollback executed for search data!");
    } catch (Exception ex) {
        addHistory(event, "Rollback not executed for search data: ".concat(ex.getMessage()));
    }
    producer.sendEvent(jsonUtil.toJson(event));
}

private void returnSearchToPreviousValues(Event event) {

}

}
