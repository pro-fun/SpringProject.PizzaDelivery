package by.academypvt.controller;

import by.academypvt.contract.UserApi;
import by.academypvt.dto.pizza.PizzaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserApi userService;
    @GetMapping("/getPizzas")
    public List<PizzaResponse> allPizzas(){
        return userService.allPizzas();
    }

}
