package by.academypvt.contract.restApi;

import by.academypvt.dto.ingredient.IngredientRequest;
import by.academypvt.dto.ingredient.IngredientResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("ingredient")
public interface IngredientRestApi {
    @GetMapping("/getIngredients")
    List<IngredientResponse> allIngredients();
    @PostMapping("/addIngredient")
    IngredientResponse addIngredient(@RequestBody @Validated IngredientRequest ingredientRequest);
    @DeleteMapping("/deleteIngredient/{id}")
    void deleteIngredient(@PathVariable("id")Long id);
}
