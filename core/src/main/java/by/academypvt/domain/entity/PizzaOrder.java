package by.academypvt.domain.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    public static class Id implements Serializable {
        @Column(name = "order_id")
        protected Long orderId;
        @Column(name = "pizza_id")
        protected Long pizzaId;
        @Column(name = "ingredient_id")
        protected Long ingredientId;
    }

    @EmbeddedId
    protected Id id = new Id();
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "pizza_id", insertable = false, updatable = false)
    private Pizza pizza;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "ingredient_id", insertable = false, updatable = false)
    private Ingredient ingredient;
    @Column(updatable = false)
    @NotNull
    private Long count;
    @Column(updatable = false)
    @NotNull
    private BigDecimal cost;

    public PizzaOrder(Order order, Pizza pizza,Ingredient ingredient, Long count) {
        this.order = order;
        this.pizza = pizza;
        this.ingredient = ingredient;
        this.count = count;

        this.id.orderId = order.getId();
        this.id.pizzaId = pizza.getId();
        this.id.ingredientId = ingredient.getId();

        order.getPizzas().add(this);
        pizza.getPizzas().add(this);
        ingredient.getPizzas().add(this);

    }


}
