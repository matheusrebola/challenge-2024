package challenge.vivo.apivivo.core.repository;

import java.util.UUID;
import challenge.vivo.apivivo.core.entities.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
