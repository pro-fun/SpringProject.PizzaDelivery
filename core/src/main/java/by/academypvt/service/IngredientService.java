package by.academypvt.service;

import by.academypvt.domain.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient findIngredientById(Long id);
    void addIngredient(Ingredient ingredient);
    void deleteIngredientById(Long id);
    List<Ingredient> updateIngredients();
}
