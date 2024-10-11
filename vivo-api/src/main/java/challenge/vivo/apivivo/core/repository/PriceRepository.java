package challenge.vivo.apivivo.core.repository;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import challenge.vivo.apivivo.core.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, UUID> {
    public List<Price> findByPriceType(PriceType priceType);
    public List<Price> findByDescription(Description description);
    public List<Price> findByRecurringPeriod(String recurringPeriod);
    public List<Price> findByProduct(Product product);
}
