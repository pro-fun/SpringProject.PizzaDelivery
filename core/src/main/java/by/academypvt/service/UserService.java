package by.academypvt.service;

import by.academypvt.dto.UserRequest;
import by.academypvt.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse findUserById(Long id);
    void addUser(UserRequest userRequest);
    void deleteUser(UserRequest userRequest);
    List<UserResponse> updateUsers();
}
