package challenge.vivo.searchservice.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import challenge.vivo.searchservice.core.enums.ESagaStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History {
    private String source;
    private ESagaStatus status;
    private String message;
    private LocalDateTime createdAt;
}