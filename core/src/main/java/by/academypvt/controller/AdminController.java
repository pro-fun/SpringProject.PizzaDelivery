package by.academypvt.controller;

import by.academypvt.contract.serviceApi.AdminApi;
import by.academypvt.dto.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminApi adminService;
    @GetMapping("/allUsers")
    public List<UserResponse> allUsers(){
        return adminService.allUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Long id){
        return (UserResponse) adminService.allUsers();
    }
    @PostMapping("/delete/user")
    public void deleteUser(Long id) {
        adminService.deleteUser(id);
    }

}
