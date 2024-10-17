package challenge.vivo.apivivo.core.repository;

import java.util.UUID;
import challenge.vivo.apivivo.core.entities.Description;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, UUID>{

}
