package by.academypvt.controller;

import by.academypvt.contract.restApi.AdminRestApi;
import by.academypvt.contract.serviceApi.AdminApi;
import by.academypvt.dto.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController implements AdminRestApi {
    private final AdminApi adminService;

    @Override
    public List<UserResponse> allUsers() {
        return adminService.allUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Long id) {
        return (UserResponse) adminService.allUsers();
    }

    @Override
    public void deleteUser(Long id) {
        adminService.deleteUser(id);
    }

}
