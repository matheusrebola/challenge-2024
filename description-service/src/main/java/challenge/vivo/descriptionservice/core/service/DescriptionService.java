package challenge.vivo.descriptionservice.core.service;

import org.springframework.stereotype.Service;

import challenge.vivo.descriptionservice.core.document.Description;
import challenge.vivo.descriptionservice.core.repository.DescriptionRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class DescriptionService {

    private final DescriptionRepository descriptionRepository;

    public List<Description> getAllDescriptions() {
        return descriptionRepository.findAll();
    }

    public Description getDescriptionById(String id) {
        return descriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Description not found"));
    }

    public Description createDescription(Description description) {
        return descriptionRepository.save(description);
    }

    public void deleteDescription(String id) {
        descriptionRepository.deleteById(id);
    }
}
