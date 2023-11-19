package by.academypvt.repository;

import by.academypvt.domain.entity.User;

import java.util.List;

public interface UserRepository {
    User findUserById(Long id);
    void addUser(User user);
    void deleteUserById(Long id);
    List<User> updateUsers();
}
