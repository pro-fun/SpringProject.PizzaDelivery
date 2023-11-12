package by.academypvt.mapper;

import by.academypvt.domain.entity.Pizza;
import by.academypvt.dto.pizza.PizzaResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PizzaMapper {
    PizzaResponse toResponse(Pizza pizza);
}
