package challenge.vivo.apivivo.core.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import challenge.vivo.apivivo.core.enums.Category;
import challenge.vivo.apivivo.core.model.Description;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, UUID> {
  public Description findByUrl(String url);
  public List<Description> findByCategory(Category category);
}
