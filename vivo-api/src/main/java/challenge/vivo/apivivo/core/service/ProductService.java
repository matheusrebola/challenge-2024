package challenge.vivo.apivivo.core.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import challenge.vivo.apivivo.core.model.Product;
import challenge.vivo.apivivo.core.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	protected final ProductRepository productRepository;
	
	public List<Product> getAll(){
		return productRepository.findAll();
	}
	
	public boolean exists(UUID id) {
		return productRepository.existsById(id);
	}
	
	public Product findById(UUID id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public void delete(Product product) {
		productRepository.delete(product);
	}
}
