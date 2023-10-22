package by.academypvt.service.impl;

import by.academypvt.domain.entity.User;
import by.academypvt.dto.user.UserRequest;
import by.academypvt.dto.user.UserResponse;
import by.academypvt.mapper.UserMapper;
import by.academypvt.repository.UserRepository;
import by.academypvt.service.UserService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserServiceJpa implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void addUser(UserRequest userRequest) {
        var user = userMapper.mapToUser(userRequest);
        userRepository.addUser(user);

    }

}