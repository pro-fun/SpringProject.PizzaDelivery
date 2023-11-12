package by.academypvt.domain.entity;

import by.academypvt.dto.order.Enums.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "delivery", name = "pizza")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Size size;
    private Float cost;
    @OneToMany(mappedBy = "pizza")
    protected List<PizzaOrder> pizzas = new ArrayList<>();
    @OneToMany(mappedBy = "pizza")
    protected List<IngredientPizza> ingredients = new ArrayList<>();


}
