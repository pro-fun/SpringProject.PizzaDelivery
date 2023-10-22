package by.academypvt.domain.entity;

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
@Entity(name = "ingredient")
@Table(schema = "delivery", name = "ingredient")
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_id")
    @SequenceGenerator(name = "ingredient_id", sequenceName = "ingredient_seq", allocationSize = 50)
    private Long id;
    private String name;
    private Float cost;
    @OneToMany(mappedBy = "ingredient")
    protected List<IngredientPizza> ingredients = new ArrayList<>();




}
