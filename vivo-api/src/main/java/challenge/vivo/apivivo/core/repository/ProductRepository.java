package challenge.vivo.apivivo.core.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import challenge.vivo.apivivo.core.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
