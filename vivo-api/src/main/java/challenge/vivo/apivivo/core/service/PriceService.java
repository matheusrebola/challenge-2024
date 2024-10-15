package challenge.vivo.apivivo.core.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import challenge.vivo.apivivo.core.enums.PriceType;
import challenge.vivo.apivivo.core.model.Description;
import challenge.vivo.apivivo.core.model.Price;
import challenge.vivo.apivivo.core.model.Product;
import challenge.vivo.apivivo.core.repository.PriceRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceService {

	private final PriceRepository priceRepository;
	
	public List<Price> getAll(){
		return priceRepository.findAll();
	}
	
	public boolean exists(UUID id) {
		return priceRepository.existsById(id);
	}
	
	public Price findById(UUID id) {
		return priceRepository.findById(id).orElse(null);
	}
	
	//métodos default
	public List<Price> findByPriceType(PriceType priceType){
		return priceRepository.findByPriceType(priceType);
	}

	public List<Price> findByDescription(Description description){
		return priceRepository.findByDescription(description);
	}

    public List<Price> findByRecurringPeriod(String recurringPeriod){
		return priceRepository.findByRecurringPeriod(recurringPeriod);
	}

    public List<Price> findByProduct(Product product){
		return priceRepository.findByProduct(product);
	}
}
