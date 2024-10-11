package challenge.vivo.apivivo.core.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import challenge.vivo.apivivo.core.model.Description;
import challenge.vivo.apivivo.core.model.Category;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, UUID> {
    public Description findByCategoria(Category category);
    public Description findByUrl(String url);
}
