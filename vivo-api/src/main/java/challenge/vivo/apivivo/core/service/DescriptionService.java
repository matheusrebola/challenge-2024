package challenge.vivo.apivivo.core.service;

import java.util.List;
import java.util.UUID;
import java.util.Locale.Category;

import org.springframework.stereotype.Service;

import challenge.vivo.apivivo.core.model.Description;
import challenge.vivo.apivivo.core.repository.DescriptionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DescriptionService {

	protected final DescriptionRepository descriptionRepository;
	
	public List<Description> getAll(){
		return descriptionRepository.findAll();
	}
	
	public boolean exists(UUID id) {
		return descriptionRepository.existsById(id);
	}
	
	public Description findById(UUID id) {
		return descriptionRepository.findById(id).orElse(null);
	}
	
	public Description save(Description description) {
		return descriptionRepository.save(description);
	}
	
	public void delete(Description description) {
		descriptionRepository.delete(description);
	}

	public Description findByUrl(String url){
		return descriptionRepository.findByUrl(url);
	}

	public List<Description> findByCategory(Category category){
		return descriptionRepository.findByCategory(category);
	}
}
