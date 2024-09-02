package challenge.vivo.apivivo.core.service;

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
}
