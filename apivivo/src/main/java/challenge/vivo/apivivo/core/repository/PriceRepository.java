package challenge.vivo.apivivo.core.repository;

import java.util.UUID;
import challenge.vivo.apivivo.core.entities.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, UUID> {

}
