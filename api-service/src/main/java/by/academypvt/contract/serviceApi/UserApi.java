package by.academypvt.contract.serviceApi;

import by.academypvt.dto.user.UserCreateRequest;
import by.academypvt.dto.user.UserLoginRequest;
import by.academypvt.dto.user.UserResponse;
import jakarta.servlet.ServletException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserApi {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    UserResponse addUser(UserCreateRequest userCreateRequest);
    UserResponse login(UserLoginRequest userLoginRequest) throws ServletException;
}
