package by.academypvt.repository.spring;

import by.academypvt.domain.entity.Order;
import by.academypvt.domain.entity.Pizza;
import by.academypvt.domain.entity.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder,Long> {
    PizzaOrder findByPizzaAndOrder(Pizza pizza, Order order);
}
