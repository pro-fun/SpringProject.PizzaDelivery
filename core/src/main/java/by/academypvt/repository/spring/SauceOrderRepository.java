package by.academypvt.repository.spring;

import by.academypvt.domain.entity.SauceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SauceOrderRepository extends JpaRepository<SauceOrder, Long> {
}
