package by.academypvt.domain.entity;

import lombok.*;

import jakarta.persistence.*;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(schema = "delivery", name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
    @SequenceGenerator(name = "user_id", sequenceName = "user_seq", allocationSize = 50)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    private String surname;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    private String address;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Order> orders;
    @OneToMany
    @JoinColumn(name = "comment")
    private List<Comment> comments;


}
