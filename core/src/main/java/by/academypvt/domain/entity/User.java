package by.academypvt.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "user")
@Table(schema = "delivery", name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
    @SequenceGenerator(name = "user_id", sequenceName = "user_seq", allocationSize = 50)
    private Long id;
    private String name;
    private String surname;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    private String email;
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;


    public User(String name, String surname, String login, String password, String address, String phoneNumber, String email) {
    }
}
