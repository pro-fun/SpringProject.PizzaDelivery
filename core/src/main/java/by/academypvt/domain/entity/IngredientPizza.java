package by.academypvt.domain.entity;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "delivery", name = "ingredient_pizza")
@org.hibernate.annotations.Immutable
public class IngredientPizza {
    @Embeddable
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Id implements Serializable {
        @Column(name = "ingredient_id")
        protected Long ingredientId;
        @Column(name = "pizza_id")
        protected Long pizzaId;
        @Column(name = "order_id")
        protected Long orderId;
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
    @JoinColumn(name = "ingredient_id", insertable = false, updatable = false)
    private Ingredient ingredient;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "pizza_id", insertable = false, updatable = false)
    private Pizza pizza;
    @Column(updatable = false)
    @NotNull
    private Long count;
    @Column(updatable = false)
    @NotNull
    private BigDecimal cost;

    public IngredientPizza(Ingredient ingredient, Pizza pizza, Order order, Long count) {
        this.ingredient = ingredient;
        this.pizza = pizza;
        this.order = order;
        this.count = count;


        this.id.ingredientId = ingredient.getId();
        this.id.pizzaId = pizza.getId();
        this.id.orderId = order.getId();

        ingredient.getIngredients().add(this);
        pizza.getIngredients().add(this);
        order.getIngredients().add(this);
    }

}
