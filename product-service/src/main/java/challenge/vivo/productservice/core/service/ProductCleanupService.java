package challenge.vivo.productservice.core.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import challenge.vivo.productservice.core.document.Product;
import challenge.vivo.productservice.core.repository.ProductRepository;

@Service
public class ProductCleanupService {

  @Autowired
    private ProductRepository productRepository;

    // Agendado para rodar todos os dias à meia-noite
    @Scheduled(cron = "0 0 0 * * ?")
    public void removeExpiredProducts() {
        // Data limite: 30 dias atrás da data atual
        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minus(30, ChronoUnit.DAYS);

        // Busca todos os produtos que não foram acessados nos últimos 30 dias
        List<Product> expiredProducts = productRepository.findByLastAccessedBefore(thirtyDaysAgo);

        // Remove os produtos expirados
        if (!expiredProducts.isEmpty()) {
            productRepository.deleteAll(expiredProducts);
        }
    }
}
