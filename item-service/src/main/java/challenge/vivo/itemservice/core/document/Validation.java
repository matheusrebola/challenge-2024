package challenge.vivo.itemservice.core.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Validation {
  @Id private Integer id;
  private String orderId;
  private String transactionId;
  private boolean success;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}
