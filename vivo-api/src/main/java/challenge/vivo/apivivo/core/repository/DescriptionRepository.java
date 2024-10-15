package challenge.vivo.apivivo.core.repository;

import java.util.List;
import java.util.UUID;
<<<<<<< HEAD
import java.util.Locale.Category;
=======
import java.util.List;
>>>>>>> refs/remotes/origin/master

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import challenge.vivo.apivivo.core.model.Description;
import challenge.vivo.apivivo.core.model.Category;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, UUID> {
<<<<<<< HEAD
  public Description findByUrl(String url);
  public List<Description> findByCategory(Category category);
=======
    public List<Description> findByCategoria(Category category);
    public Description findByUrl(String url);
>>>>>>> refs/remotes/origin/master
}
