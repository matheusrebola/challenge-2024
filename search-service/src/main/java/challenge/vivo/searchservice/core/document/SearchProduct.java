package challenge.vivo.searchservice.core.document;

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
public class SearchProduct{
  @Id String id;
  private Product product;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  
  public void prePersist() {
    var now = LocalDateTime.now();
    createdAt = now;
    updatedAt = now;
  }

    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
} 
