package challenge.vivo.orchestratorservice.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ETopics {

    START_SAGA("start-saga"),
    BASE_ORCHESTRATOR("orchestrator"),
    FINISH_SUCCESS("finish-success"),
    FINISH_FAIL("finish-fail"),
    ITEM_SUCCESS("item-success"),
    ITEM_FAIL("item-fail"),
    SEARCH_SUCCESS("search-success"),
    SEARCH_FAIL("search-fail"),
    UPDATE_SUCCESS("update-success"),
    UPDATE_FAIL("update-fail"),
    NOTIFY_ENDING("notify-ending");

    private final String topic;
    
}
