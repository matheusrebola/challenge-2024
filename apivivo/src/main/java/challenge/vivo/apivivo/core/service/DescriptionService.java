package challenge.vivo.apivivo.core.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import challenge.vivo.apivivo.core.entities.Description;
import challenge.vivo.apivivo.core.repository.DescriptionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DescriptionService {
    private final DescriptionRepository descriptionRepository;

    public List<Description> findAll(){
        return descriptionRepository.findAll();
    }

    public Description findById(UUID id){
        return descriptionRepository.findById(id).orElse(null);
    }

    public Description saveDescription(Description description){
        return descriptionRepository.save(description);
    }

}
