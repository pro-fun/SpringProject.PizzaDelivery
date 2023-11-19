package by.academypvt.service.impl;

import by.academypvt.contract.serviceApi.IngredientApi;
import by.academypvt.domain.entity.Ingredient;
import by.academypvt.dto.ingredient.IngredientRequest;
import by.academypvt.dto.ingredient.IngredientResponse;
import by.academypvt.errors.FoodEntityException;
import by.academypvt.mapper.IngredientMapper;
import by.academypvt.repository.spring.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientApi{
    private final IngredientMapper ingredientMapper;
    private final IngredientRepository ingredientRepository;

    @Override
    public IngredientResponse addIngredient(IngredientRequest ingredientRequest) {
            if (ingredientRepository.findByName(ingredientRequest.getName()) != null) {
                throw new FoodEntityException("Данный ингредиент уже есть в базе данных");
            }
            Ingredient ingredient = ingredientMapper.toEntity(ingredientRequest);
            return ingredientMapper.toResponse(ingredientRepository.save(ingredient));
        }

    @Override
    public List<IngredientResponse> allIngredients() {
        return ingredientRepository.findAll().stream().map(ingredientMapper::toResponse).collect(Collectors.toList());
    }
}
