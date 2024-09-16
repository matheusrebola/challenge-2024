package challenge.vivo.orchestratorservice.core.saga;

import static challenge.vivo.orchestratorservice.core.enums.EEventSource.*;
import static challenge.vivo.orchestratorservice.core.enums.ESagaStatus.*;
import static challenge.vivo.orchestratorservice.core.enums.ETopics.*;

public class SagaHandler {
  private SagaHandler() {

  }

  public static final Object[][] SAGA_HANDLER = {
      { ORCHESTRATOR, SUCCESS, PRODUCT_SUCCESS },
      { ORCHESTRATOR, FAIL, FINISH_FAIL },

      { PRODUCT_SERVICE, ROLLBACK_PENDING, PRODUCT_FAIL },
      { PRODUCT_SERVICE, FAIL, FINISH_FAIL },
      { PRODUCT_SERVICE, SUCCESS, PRICE_SUCCESS },

      { PRICE_SERVICE, ROLLBACK_PENDING, PRICE_FAIL },
      { PRICE_SERVICE, FAIL, PRODUCT_FAIL },
      { PRICE_SERVICE, SUCCESS, DESCRIPTION_SUCCESS },

      { DESCRIPTION_SERVICE, ROLLBACK_PENDING, DESCRIPTION_FAIL },
      { DESCRIPTION_SERVICE, FAIL, PRICE_FAIL },
      { DESCRIPTION_SERVICE, SUCCESS, FINISH_SUCCESS }
  };

  public static final int EVENT_SOURCE_INDEX = 0;
  public static final int SAGA_STATUS_INDEX = 1;
  public static final int TOPIC_INDEX = 2;
}
