package challenge.vivo.apivivo.core.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import challenge.vivo.apivivo.core.entities.Description;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, UUID>{

}
