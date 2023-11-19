package by.academypvt.controller;

import by.academypvt.contract.restApi.RegistrationRestApi;
import by.academypvt.contract.serviceApi.UserApi;
import by.academypvt.dto.user.UserCreateRequest;
import by.academypvt.dto.user.UserLoginRequest;
import by.academypvt.dto.user.UserResponse;
import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController implements RegistrationRestApi {
    private final UserApi userService;
    @Override
    public UserResponse addUser(UserCreateRequest userCreateRequest) {
        return userService.addUser(userCreateRequest);
    }

    @Override
    public UserResponse login(UserLoginRequest userLoginRequest) throws ServletException {
        return userService.login(userLoginRequest);
    }
}
