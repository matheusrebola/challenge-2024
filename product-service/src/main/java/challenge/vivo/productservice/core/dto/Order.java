package challenge.vivo.productservice.core.dto;

import java.time.LocalDateTime;
import java.util.List;

public record Order(
  String id,
  List<OrderProducts> products,
  LocalDateTime createdAt,
  String transactionId,
  double totalAmount,
  int totalItems
) {

}
