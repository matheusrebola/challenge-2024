package challenge.vivo.productservice.core.service;

import java.util.List;
import org.springframework.stereotype.Service;

import challenge.vivo.productservice.core.document.Product;
import challenge.vivo.productservice.core.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
   private final ProductRepository productRepository;

    public List<Product> getAllPrices() {
        return productRepository.findAll();
    }

    public Product getPriceById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Description not found"));
    }

    public Product createPrice(Product product) {
        return productRepository.save(product);
    }

    public void deletePrice(String id) {
        productRepository.deleteById(id);
    }    

}
