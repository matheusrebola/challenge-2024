package challenge.vivo.itemservice.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import challenge.vivo.itemservice.core.document.Product;
import challenge.vivo.itemservice.core.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public Product findById(String id){
    return productRepository.findById(id).orElse(null);
  }

  public List<Product> findAll(){
    return productRepository.findAll();
  }

  public Product saveProduct(Product product){
    return productRepository.save(product);
  }

  

}
