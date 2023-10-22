package by.academypvt.domain.entity;

import by.academypvt.dto.order.DeliveryType;
import by.academypvt.dto.order.State;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "order")
@Table(schema = "delivery", name = "order")
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

    private DeliveryType deliveryType;
    private Float cost;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Position> positions;


    public Order(String orderTime, Float cost, State state, DeliveryType deliveryType) {
    }
}
