package by.academypvt.contract.restApi;

import by.academypvt.dto.user.UserCreateRequest;
import by.academypvt.dto.user.UserLoginRequest;
import by.academypvt.dto.user.UserResponse;
import jakarta.servlet.ServletException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "registration")
public interface RegistrationRestApi {
    @PostMapping("/addUser")
    UserResponse addUser(@RequestBody @Validated UserCreateRequest userCreateRequest);
    @PostMapping("/login")
    UserResponse login(@RequestBody @Validated UserLoginRequest userLoginRequest) throws ServletException;

}
