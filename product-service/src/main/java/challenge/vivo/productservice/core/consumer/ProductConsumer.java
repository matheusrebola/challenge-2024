package challenge.vivo.productservice.core.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import challenge.vivo.productservice.core.document.Product;
import challenge.vivo.productservice.core.service.ProductService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductConsumer {

  private final ObjectMapper objectMapper;
  private final ProductService productService;

  @KafkaListener(topics = "products", groupId = "product-group")
    public void consume(ConsumerRecord<String, String> record) {
        try {
            // Converte a mensagem recebida do Kafka para um objeto Product
            Product product = objectMapper.readValue(record.value(), Product.class);

            // Chama o serviço para atualizar ou inserir o produto no MongoDB
            productService.updateProduct(product);

        } catch (Exception e) {
            // Trate possíveis erros de deserialização ou atualização
            e.printStackTrace();
        }
    }

}
