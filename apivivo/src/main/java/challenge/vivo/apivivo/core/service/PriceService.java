package challenge.vivo.apivivo.core.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import challenge.vivo.apivivo.core.entities.Price;
import challenge.vivo.apivivo.core.repository.PriceRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceService {
    private final PriceRepository priceRepository;

    public List<Price> findAll(){
        return priceRepository.findAll();
    }

    public Price findById(UUID id){
        return priceRepository.findById(id).orElse(null);
    }

    public Price savPrice(Price price){
        return priceRepository.save(price);
    }
}
