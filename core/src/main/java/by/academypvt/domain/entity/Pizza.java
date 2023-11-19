package by.academypvt.domain.entity;

import by.academypvt.dto.order.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "pizza")
@Table(schema = "delivery", name = "pizza")
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pizza_id")
    @SequenceGenerator(name = "pizza_id", sequenceName = "pizza_seq", allocationSize = 50)
    private Long id;
    private String name;
    private Size size;
    private Float cost;
    @OneToMany(mappedBy = "pizza")
    protected List<PizzaOrder> pizzas = new ArrayList<>();
    @OneToMany(mappedBy = "pizza")
    protected List<IngredientPizza> ingredients = new ArrayList<>();


}
