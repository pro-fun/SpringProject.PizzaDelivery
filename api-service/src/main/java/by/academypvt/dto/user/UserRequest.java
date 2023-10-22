package by.academypvt.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private String email;
    private String login;
    private String password;
}
