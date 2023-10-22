package by.academypvt.domain.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "delivery", name = "pizza_order")
@org.hibernate.annotations.Immutable
public class PizzaOrder {
    @Embeddable
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Id implements Serializable{
        @Column(name = "order_id")
        protected Long orderId;
        @Column(name = "pizza_id")
        protected Long pizzaId;
    }
    @EmbeddedId
    protected Id id = new Id();
    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "pizza_id", insertable = false, updatable = false)
    private Pizza pizza;
    @Column(updatable = false)
    @NotNull
    private Long count;
    @Column(updatable = false)
    @NotNull
    private Float cost;
    public PizzaOrder(Order order,Pizza pizza, Long count){
        this.order = order;
        this.pizza = pizza;
        this.count = count;

        this.id.orderId = order.getId();
        this.id.pizzaId = pizza.getId();

        order.getPizzas().add(this);
        pizza.getPizzas().add(this);
    }





}
