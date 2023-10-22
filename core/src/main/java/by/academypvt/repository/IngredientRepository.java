package by.academypvt.repository;

import by.academypvt.domain.entity.Ingredient;


import java.util.List;

public interface IngredientRepository {
    Ingredient findIngredientById(Long id);
    void addIngredient(Ingredient ingredient);
    void deleteIngredientById(Long id);
    List<Ingredient> updateIngredients();
}
