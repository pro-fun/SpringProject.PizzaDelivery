package by.academypvt.service.impl;

import by.academypvt.domain.entity.Ingredient;
import by.academypvt.repository.IngredientRepository;
import by.academypvt.service.IngredientService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class IngredientServiceJpa implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Override
    public Ingredient findIngredientById(Long id) {
        return ingredientRepository.findIngredientById(id);
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredientRepository.addIngredient(ingredient);
    }

    @Override
    public void deleteIngredientById(Long id) {
        ingredientRepository.deleteIngredientById(id);
    }

    @Override
    public List<Ingredient> updateIngredients() {
        return ingredientRepository.updateIngredients();
    }
}
