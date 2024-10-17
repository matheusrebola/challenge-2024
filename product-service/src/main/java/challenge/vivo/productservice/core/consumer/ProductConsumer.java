package challenge.vivo.productservice.core.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductConsumer {

  @KafkaListener(topics = "products", groupId = "product-group")
    public void consume(ConsumerRecord<String, String> record) {
    }
}
