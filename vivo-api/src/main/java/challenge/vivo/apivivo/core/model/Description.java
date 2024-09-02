package challenge.vivo.apivivo.core.model;

@Entity
public record Description(
	@Id @GeneratedValue(strategy = GenerationType.UUID) UUID id) {

}
