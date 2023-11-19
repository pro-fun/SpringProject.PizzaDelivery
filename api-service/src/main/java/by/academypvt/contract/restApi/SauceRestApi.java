package by.academypvt.contract.restApi;

import by.academypvt.dto.pizza.PizzaRequest;
import by.academypvt.dto.pizza.PizzaResponse;
import by.academypvt.dto.sauce.SauceRequest;
import by.academypvt.dto.sauce.SauceResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("sauce")
public interface SauceRestApi {
    @GetMapping("/getSauces")
    List<SauceResponse> allSauces();
    @PostMapping("/addSauce")
    SauceResponse addSauce(@RequestBody @Validated SauceRequest sauceRequest);
    @DeleteMapping("/deleteSauce/{id}")
    void deleteSauce(@PathVariable("id")Long id);
}
