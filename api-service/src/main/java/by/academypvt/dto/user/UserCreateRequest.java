package by.academypvt.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserCreateRequest {
    @NotBlank
    private String name;
    private String surname;
    @NotBlank
    private String phoneNumber;
    private String address;
    private String email;
    @NotBlank(message = "Пустой логин")
    private String login;
    @NotBlank(message = "Пустой пароль")
    private String password;
}
