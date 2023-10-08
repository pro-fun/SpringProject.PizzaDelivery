package by.academypvt.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "sauce")
@Table(schema = "delivery", name = "sauce")
public class Sauce {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sauce_id")
    @SequenceGenerator(name = "sauce_id", sequenceName = "sauce_seq", allocationSize = 50)
    private Long id;
    private String name;
    private Float cost;
    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(schema = "delivery", name = "sauce_for_positions",
            joinColumns = {@JoinColumn(name = "sauce_id")},
            inverseJoinColumns = {@JoinColumn(name = "position_id")})
    private List<Position> positions;
}
