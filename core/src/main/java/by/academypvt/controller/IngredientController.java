package by.academypvt.controller;

import by.academypvt.contract.restApi.IngredientRestApi;
import by.academypvt.contract.serviceApi.IngredientApi;
import by.academypvt.dto.ingredient.IngredientRequest;
import by.academypvt.dto.ingredient.IngredientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IngredientController implements IngredientRestApi {
    private final IngredientApi ingredientService;

    @Override
    public List<IngredientResponse> allIngredients() {
        return ingredientService.allIngredients();
    }

    @Override
    public IngredientResponse addIngredient(IngredientRequest ingredientRequest) {
        return ingredientService.addIngredient(ingredientRequest);
    }
}
