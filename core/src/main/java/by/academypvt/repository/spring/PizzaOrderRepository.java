package by.academypvt.repository.spring;

import by.academypvt.domain.entity.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder,Long> {
}
