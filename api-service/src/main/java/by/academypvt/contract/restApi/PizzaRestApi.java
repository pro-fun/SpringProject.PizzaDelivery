package by.academypvt.contract.restApi;

import by.academypvt.dto.pizza.PizzaRequest;
import by.academypvt.dto.pizza.PizzaResponse;
import by.academypvt.dto.pizza.PizzaSizeRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("pizza")
public interface PizzaRestApi {
    @GetMapping("/getPizzas")
    List<PizzaResponse> allPizzas();
    @PostMapping("/addPizza")
    PizzaResponse addPizza(@RequestBody @Validated PizzaRequest pizzaRequest);
    @DeleteMapping("/deletePizza/{id}")
    void deletePizza(@PathVariable("id")Long id);
    @PutMapping("/getPizzasBySize")
    List<PizzaResponse> getPizzasBySize(@RequestBody @Validated PizzaSizeRequest pizzaSizeRequest);

}
