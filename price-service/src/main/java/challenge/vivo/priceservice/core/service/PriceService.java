package challenge.vivo.priceservice.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import challenge.vivo.priceservice.core.document.Price;
import challenge.vivo.priceservice.core.repository.PriceRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public Price getPriceById(String id) {
        return priceRepository.findById(id).orElseThrow(() -> new RuntimeException("Description not found"));
    }

    public Price createPrice(Price price) {
        return priceRepository.save(price);
    }

    public void deletePrice(String id) {
        priceRepository.deleteById(id);
    }
}
