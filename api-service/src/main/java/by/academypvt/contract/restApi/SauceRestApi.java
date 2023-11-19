package by.academypvt.contract.restApi;

import by.academypvt.dto.pizza.PizzaRequest;
import by.academypvt.dto.pizza.PizzaResponse;
import by.academypvt.dto.sauce.SauceRequest;
import by.academypvt.dto.sauce.SauceResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("sauce")
public interface SauceRestApi {
    @GetMapping("/getSauces")
    List<SauceResponse> allSauces();
    @PostMapping("/addSauce")
    SauceResponse addSauce(@RequestBody @Validated SauceRequest sauceRequest);
}
