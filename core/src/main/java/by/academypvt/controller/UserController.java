package by.academypvt.controller;

import by.academypvt.contract.restApi.UserRestApi;
import by.academypvt.contract.serviceApi.UserApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserRestApi {
    private final UserApi userService;



}
