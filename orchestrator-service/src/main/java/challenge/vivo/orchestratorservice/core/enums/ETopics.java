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
    PRODUCT_SUCCESS("product-success"),
    PRODUCT_FAIL("product-fail"),
    PRICE_SUCCESS("price-success"),
    PRICE_FAIL("price-fail"),
    DESCRIPTION_SUCCESS("description-success"),
    DESCRIPTION_FAIL("description-fail"),
    NOTIFY_ENDING("notify-ending");

    private final String topic;
    
}
