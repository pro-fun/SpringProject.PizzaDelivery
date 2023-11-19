package by.academypvt.domain.entity;

import by.academypvt.dto.enums.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;

import java.math.BigDecimal;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pizza_id")
    @SequenceGenerator(name = "pizza_id", sequenceName = "pizza_seq", allocationSize = 50)
    private Long id;
    private String name;
    private Size size;
    private BigDecimal cost;
    @OneToMany(mappedBy = "pizza", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    protected List<PizzaOrder> pizzas = new ArrayList<>();
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "pizza", fetch = FetchType.LAZY)
    protected List<IngredientPizza> ingredients = new ArrayList<>();


}
