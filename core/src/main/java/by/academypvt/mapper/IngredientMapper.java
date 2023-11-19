package by.academypvt.mapper;

import by.academypvt.domain.entity.Ingredient;
import by.academypvt.dto.ingredient.IngredientRequest;
import by.academypvt.dto.ingredient.IngredientResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientMapper {
    IngredientResponse toResponse(Ingredient ingredient);
    Ingredient toEntity(IngredientRequest ingredientRequest);
}
