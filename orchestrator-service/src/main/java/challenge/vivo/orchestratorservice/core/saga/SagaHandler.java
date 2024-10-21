package challenge.vivo.orchestratorservice.core.saga;

import static challenge.vivo.orchestratorservice.core.enums.EEventSource.ITEM_SERVICE;
import static challenge.vivo.orchestratorservice.core.enums.EEventSource.ORCHESTRATOR;
import static challenge.vivo.orchestratorservice.core.enums.EEventSource.SEARCH_SERVICE;
import static challenge.vivo.orchestratorservice.core.enums.EEventSource.UPDATE_SERVICE;
import static challenge.vivo.orchestratorservice.core.enums.ESagaStatus.FAIL;
import static challenge.vivo.orchestratorservice.core.enums.ESagaStatus.NOT_FOUND;
import static challenge.vivo.orchestratorservice.core.enums.ESagaStatus.ROLLBACK_PENDING;
import static challenge.vivo.orchestratorservice.core.enums.ESagaStatus.SUCCESS;
import static challenge.vivo.orchestratorservice.core.enums.ETopics.FINISH_FAIL;
import static challenge.vivo.orchestratorservice.core.enums.ETopics.FINISH_SUCCESS;
import static challenge.vivo.orchestratorservice.core.enums.ETopics.ITEM_FAIL;
import static challenge.vivo.orchestratorservice.core.enums.ETopics.ITEM_SUCCESS;
import static challenge.vivo.orchestratorservice.core.enums.ETopics.SEARCH_FAIL;
import static challenge.vivo.orchestratorservice.core.enums.ETopics.UPDATE_FAIL;
import static challenge.vivo.orchestratorservice.core.enums.ETopics.UPDATE_SUCCESS;

public class SagaHandler {
  private SagaHandler() {

  }

  public static final Object[][] SAGA_HANDLER = {
      { ORCHESTRATOR, SUCCESS, ITEM_SUCCESS },
      { ORCHESTRATOR, FAIL, FINISH_FAIL },

      { ITEM_SERVICE, NOT_FOUND, SEARCH_SERVICE },
      { ITEM_SERVICE, ROLLBACK_PENDING, ITEM_FAIL },
      { ITEM_SERVICE, FAIL, FINISH_FAIL },
      { ITEM_SERVICE, SUCCESS, FINISH_SUCCESS },

      { SEARCH_SERVICE, ROLLBACK_PENDING, SEARCH_FAIL },
      { SEARCH_SERVICE, FAIL, ITEM_FAIL },
      { SEARCH_SERVICE, SUCCESS, UPDATE_SUCCESS },

      { UPDATE_SERVICE, ROLLBACK_PENDING, UPDATE_FAIL },
      { UPDATE_SERVICE, FAIL, SEARCH_FAIL },
      { UPDATE_SERVICE, SUCCESS, FINISH_SUCCESS }
  };

  public static final int EVENT_SOURCE_INDEX = 0;
  public static final int SAGA_STATUS_INDEX = 1;
  public static final int TOPIC_INDEX = 2;
}
