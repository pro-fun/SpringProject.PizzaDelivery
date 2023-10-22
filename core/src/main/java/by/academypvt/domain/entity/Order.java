package by.academypvt.domain.entity;

import by.academypvt.dto.order.DeliveryType;
import by.academypvt.dto.order.State;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "order")
@Table(schema = "delivery", name = "order")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id")
    @SequenceGenerator(name = "order_id", sequenceName = "order_seq", allocationSize = 50)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "order_time")
    private String orderTime;

    private State state;
    private String comment;

    private DeliveryType deliveryType;
    private Float cost;
    @OneToMany(mappedBy = "order")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<PizzaOrder> pizzas = new ArrayList<>();
    @OneToMany(mappedBy = "order")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    protected List<SauceOrder> sauces = new ArrayList<>();


    public Order(String orderTime, Float cost, State state, DeliveryType deliveryType) {
    }
}
