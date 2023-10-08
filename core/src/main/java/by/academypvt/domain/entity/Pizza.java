package by.academypvt.domain.entity;

import by.academypvt.dto.order.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "pizza")
@Table(schema = "delivery", name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pizza_id")
    @SequenceGenerator(name = "pizza_id", sequenceName = "pizza_seq", allocationSize = 50)
    private Long id;
    private String name;
    private Size size;
    private Float cost;

    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(schema = "delivery", name = "pizzas_for_positions",
            joinColumns = {@JoinColumn(name = "pizza_id")},
            inverseJoinColumns = {@JoinColumn(name = "position_id")})
    private List<Position> positions;

}
