package by.academypvt.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity(name = "position")
@Table(schema = "delivery", name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_id")
    @SequenceGenerator(name = "position_id", sequenceName = "position_seq", allocationSize = 50)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToMany(mappedBy = "positions", fetch = FetchType.LAZY)
    Collection<Pizza> pizzas;

    @ManyToMany(mappedBy = "positions", fetch = FetchType.LAZY)
    Collection<Sauce> sauces;

    @ManyToMany(mappedBy = "positions", fetch = FetchType.LAZY)
    Collection<Ingredient> ingredients;

    private Integer quantity;

    private Float cost;

}
