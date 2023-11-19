package by.academypvt.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserLoginRequest {
    @NotBlank(message = "Пустой логин")
    private String login;
    @NotBlank(message = "Пустой пароль")
    private String password;
}
