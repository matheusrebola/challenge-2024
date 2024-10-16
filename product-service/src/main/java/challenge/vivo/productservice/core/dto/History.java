package challenge.vivo.productservice.core.dto;

import java.time.LocalDateTime;

import challenge.vivo.productservice.core.enums.SagaStatus;

public record History(
  String source,
  SagaStatus status,
  String message,
  LocalDateTime createdAt
) {

}
