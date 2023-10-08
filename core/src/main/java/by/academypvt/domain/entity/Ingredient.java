package by.academypvt.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "ingredient")
@Table(schema = "delivery", name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_id")
    @SequenceGenerator(name = "ingredient_id", sequenceName = "ingredient_seq", allocationSize = 50)
    private Long id;
    private String name;
    private Float cost;

    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(schema = "delivery", name = "ingredient_for_positions",
            joinColumns = {@JoinColumn(name = "ingredient_id")},
            inverseJoinColumns = {@JoinColumn(name = "position_id")})
    private List<Position> positions;

}
