package by.academypvt.service.impl;

import by.academypvt.dto.UserRequest;
import by.academypvt.dto.UserResponse;
import by.academypvt.repository.UserRepository;
import by.academypvt.service.UserService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserServiceJpa implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse findUserById(Long id) {
        return null;
    }

    @Override
    public void addUser(UserRequest userRequest) {

    }

    @Override
    public void deleteUser(UserRequest userRequest) {

    }

    @Override
    public List<UserResponse> updateUsers() {
        return null;
    }
}
