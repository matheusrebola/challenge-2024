package challenge.vivo.apivivo.core.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import challenge.vivo.apivivo.core.entities.Product;
import challenge.vivo.apivivo.core.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(UUID id){
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}
