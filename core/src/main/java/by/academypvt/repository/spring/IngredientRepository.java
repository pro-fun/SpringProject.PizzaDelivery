package by.academypvt.repository.spring;

import by.academypvt.domain.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
    Ingredient findByName(String name);
}
