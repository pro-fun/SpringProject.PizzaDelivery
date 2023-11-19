package by.academypvt.contract.restApi;

import by.academypvt.dto.pizza.PizzaRequest;
import by.academypvt.dto.pizza.PizzaResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("pizza")
public interface PizzaRestApi {
    @GetMapping("/getPizzas")
    List<PizzaResponse> allPizzas();
    @PostMapping("/addPizza")
    PizzaResponse addPizza(@RequestBody @Validated PizzaRequest pizzaRequest);
}
