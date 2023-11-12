package by.academypvt.domain.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.io.Serializable;

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
    }

    @EmbeddedId
    protected Id id = new Id();
    @ManyToOne
    @JoinColumn(name = "ingredient_id", insertable = false, updatable = false)
    private Ingredient ingredient;
    @ManyToOne
    @JoinColumn(name = "pizza_id", insertable = false, updatable = false)
    private Pizza pizza;
    @Column(updatable = false)
    @NotNull
    private Long count;
    @Column(updatable = false)
    @NotNull
    private Float cost;

    public IngredientPizza(Ingredient ingredient, Pizza pizza, Long count) {
        this.ingredient = ingredient;
        this.pizza = pizza;
        this.count = count;

        this.id.ingredientId = ingredient.getId();
        this.id.pizzaId = pizza.getId();

        ingredient.getIngredients().add(this);
        pizza.getIngredients().add(this);
    }

}
