package by.academypvt.contract;

import by.academypvt.dto.user.UserResponse;

import java.util.List;

public interface AdminApi {
    List<UserResponse> allUsers();
    UserResponse getUserById(Long id);
    void deleteUser(Long id);


}
