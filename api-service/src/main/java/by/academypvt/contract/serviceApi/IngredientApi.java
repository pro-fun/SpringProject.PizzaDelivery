package by.academypvt.contract.serviceApi;

import by.academypvt.dto.ingredient.IngredientRequest;
import by.academypvt.dto.ingredient.IngredientResponse;

import java.util.List;

public interface IngredientApi {
    List<IngredientResponse> allIngredients();
    IngredientResponse addIngredient(IngredientRequest ingredientRequest);
    void deleteIngredient(Long id);
}
