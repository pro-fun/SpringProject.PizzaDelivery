package by.academypvt.mapper;

import by.academypvt.domain.entity.User;
import by.academypvt.dto.user.UserRequest;
import by.academypvt.dto.user.UserResponse;

public class UserMapper {
    public User mapToUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setLogin(userRequest.getLogin());
        user.setPassword(userRequest.getPassword());
        user.setAddress(userRequest.getAddress());
        user.setEmail(userRequest.getEmail());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        return user;
    }

    public UserResponse mapFromUser(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        userResponse.setAddress(user.getAddress());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhoneNumber(userResponse.getPhoneNumber());
        return userResponse;
    }
}
