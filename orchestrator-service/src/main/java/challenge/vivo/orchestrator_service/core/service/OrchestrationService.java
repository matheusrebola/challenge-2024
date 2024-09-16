package challenge.vivo.orchestrator_service.core.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import challenge.vivo.orchestrator_service.core.dto.Event;
import challenge.vivo.orchestrator_service.core.dto.History;
import challenge.vivo.orchestrator_service.core.enums.ETopics;
import challenge.vivo.orchestrator_service.core.producer.SagaOrchestratorProducer;
import challenge.vivo.orchestrator_service.core.saga.SagaExecutionController;
import challenge.vivo.orchestrator_service.core.utils.JsonUtils;
import static challenge.vivo.orchestrator_service.core.enums.EEventSource.ORCHESTRATOR;
import static challenge.vivo.orchestrator_service.core.enums.ESagaStatus.FAIL;
import static challenge.vivo.orchestrator_service.core.enums.ESagaStatus.SUCCESS;

@Slf4j
@Service
@AllArgsConstructor
public class OrchestrationService {
  private final SagaOrchestratorProducer producer;

    private final JsonUtils jsonUtil;
    private final SagaExecutionController sagaExecutionController;

    public void startSaga(Event event) {
        event.setSource(ORCHESTRATOR);
        event.setStatus(SUCCESS);
        var topic = getTopic(event);
        log.info("SAGA STARTED!");
        addHistory(event, "Saga started!");
        sendToProducerWithTopic(event, topic);
    }

    public void finishSagaSuccess(Event event) {
        event.setSource(ORCHESTRATOR);
        event.setStatus(SUCCESS);
        log.info("SAGA FINISHED SUCCESSFULLY FOR EVENT {}!", event.getId());
        addHistory(event, "Saga finished successfully!");
        notifyFinishedSaga(event);
    }

    public void finishSagaFail(Event event) {
        event.setSource(ORCHESTRATOR);
        event.setStatus(FAIL);
        log.info("SAGA FINISHED WITH ERRORS FOR EVENT {}!", event.getId());
        addHistory(event, "Saga finished with errors!");
        notifyFinishedSaga(event);
    }

    public void continueSaga(Event event) {
        var topic = getTopic(event);
        log.info("SAGA CONTINUING FOR EVENT {}", event.getId());
        sendToProducerWithTopic(event, topic);
    }

    private ETopics getTopic(Event event) {
        return sagaExecutionController.getNextTopic(event);
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

    private void sendToProducerWithTopic(Event event, ETopics topic) {
        producer.sendEvent(jsonUtil.toJson(event), topic.getTopic());
    }

    private void notifyFinishedSaga(Event event) {
        producer.sendEvent(jsonUtil.toJson(event), ETopics.NOTIFY_ENDING.getTopic());
    }
}
