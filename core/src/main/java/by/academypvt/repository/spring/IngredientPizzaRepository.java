package by.academypvt.repository.spring;

import by.academypvt.domain.entity.IngredientPizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientPizzaRepository extends JpaRepository<IngredientPizza,Long> {
}
