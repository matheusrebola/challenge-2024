package challenge.vivo.orchestrator_service.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import challenge.vivo.orchestrator_service.core.enums.EEventSource;
import challenge.vivo.orchestrator_service.core.enums.ESagaStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History {
    private EEventSource source;
    private ESagaStatus status;
    private String message;
    private LocalDateTime createdAt;
}
