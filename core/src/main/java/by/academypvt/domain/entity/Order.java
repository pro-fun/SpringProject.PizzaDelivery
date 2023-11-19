package by.academypvt.domain.entity;

import by.academypvt.dto.enums.DeliveryType;
import by.academypvt.dto.enums.State;
import lombok.*;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Entity
@Table(schema = "delivery", name = "order")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id")
    @SequenceGenerator(name = "order_id", sequenceName = "order_seq", allocationSize = 50)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "order_time")
    private String orderTime;

    private State state;
    private String comment;
    @Column(name = "delivery_type")
    private DeliveryType deliveryType;
    private BigDecimal cost;
    @OneToMany(mappedBy = "order")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<PizzaOrder> pizzas = new ArrayList<>();
    @OneToMany(mappedBy = "order")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<SauceOrder> sauces = new ArrayList<>();
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @ToString.Exclude
    protected List<IngredientPizza> ingredients = new ArrayList<>();

}
