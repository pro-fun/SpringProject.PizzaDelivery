package by.academypvt.repository.spring;

import by.academypvt.domain.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientPizzaRepository extends JpaRepository<IngredientPizza,Long> {
    IngredientPizza findByIngredientAndPizzaAndOrder(Ingredient ingredient,Pizza pizza, Order order);
}
