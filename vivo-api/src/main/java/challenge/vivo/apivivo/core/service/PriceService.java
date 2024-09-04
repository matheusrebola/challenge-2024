package challenge.vivo.apivivo.core.service;

@Service
@RequiredArgsConstructor
public class PriceService {

	protected final PriceRepository priceRepository;
	
	public List<Price> getAll(){
		return priceRepository.findAll();
	}
	
	public boolean exists(UUID id) {
		return priceRepository.existsById(id);
	}
	
	public Price findById(UUID id) {
		return priceRepository.findById(id).orElse(null);
	}

}
