package by.academypvt.contract.restApi;

import by.academypvt.dto.ingredient.IngredientRequest;
import by.academypvt.dto.ingredient.IngredientResponse;
import by.academypvt.dto.pizza.PizzaRequest;
import by.academypvt.dto.pizza.PizzaResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("ingredient")
public interface IngredientRestApi {
    @GetMapping("/getIngredients")
    List<IngredientResponse> allIngredients();
    @PostMapping("/addIngredient")
    IngredientResponse addIngredient(@RequestBody @Validated IngredientRequest ingredientRequest);
}
