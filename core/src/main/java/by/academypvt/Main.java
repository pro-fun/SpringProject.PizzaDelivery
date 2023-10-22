package by.academypvt;

import by.academypvt.config.UserConfig;
import by.academypvt.domain.entity.Ingredient;
import by.academypvt.domain.entity.Pizza;
import by.academypvt.domain.entity.User;
import by.academypvt.dto.order.Size;
import by.academypvt.dto.user.UserRequest;
import by.academypvt.repository.IngredientRepository;
import by.academypvt.repository.PizzaRepository;
import by.academypvt.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        UserRequest user1 = new UserRequest();
//        user1.setName("Владимир");
//        user1.setSurname("Новик");
//        user1.setLogin("admin");
//        user1.setPassword("654123");
//        user1.setAddress("Гомель");
//        user1.setPhoneNumber("+375291234567");
//        user1.setEmail("vladimir@mail.com");
//
//    UserService userService = ApplicationContext.getInstance().getUserService();
//    userService.addUser(user1);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserConfig.class);

    }
}