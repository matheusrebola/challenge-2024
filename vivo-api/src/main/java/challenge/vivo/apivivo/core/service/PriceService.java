package challenge.vivo.apivivo.core.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import challenge.vivo.apivivo.core.model.Price;
import challenge.vivo.apivivo.core.repository.PriceRepository;
import lombok.RequiredArgsConstructor;

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
