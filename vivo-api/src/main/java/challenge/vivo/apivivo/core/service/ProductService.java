package challenge.vivo.apivivo.core.service;

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
