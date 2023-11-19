package by.academypvt.contract.restApi;

import by.academypvt.dto.user.UserResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("admin")
public interface AdminRestApi {
    @GetMapping("/allUsers")
    List<UserResponse> allUsers();
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable("id") Long id);
}
