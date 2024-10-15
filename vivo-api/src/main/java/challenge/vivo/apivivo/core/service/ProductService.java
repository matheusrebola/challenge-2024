package challenge.vivo.apivivo.core.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import challenge.vivo.apivivo.core.enums.SubscriptionType;
import challenge.vivo.apivivo.core.model.Price;
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

<<<<<<< HEAD
=======
	//metodos default
>>>>>>> refs/remotes/origin/master
	public List<Product> findByProductName(String productName){
		return productRepository.findByProductName(productName);
	}

<<<<<<< HEAD
	public List<Product> findBySubscriptionType(SubscriptionType subscriptionType){
		return productRepository.findBySubscriptionType(subscriptionType);
	}

	public List<Product> findByPrice(Price price){
=======
    public List<Product> findByProductType(ProductType productType){
		return productRepository.findByProductType(productType);
	}

    public List<Product> findByDescription(Description description){
		return productRepository.findByDescription(description);
	}

    public List<Product> findBySubscriptionType(SubscriptionType subscriptionType){
		return productRepository.findBySubscriptionType(subscriptionType);
	}

    public List<Product> findByPrice(Price price){
>>>>>>> refs/remotes/origin/master
		return productRepository.findByPrice(price);
	}
}
