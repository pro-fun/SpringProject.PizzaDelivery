package by.academypvt.domain.entity;

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
@Table(schema = "delivery", name = "sauce")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "sauce")
public class Sauce {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sauce_id")
    @SequenceGenerator(name = "sauce_id", sequenceName = "sauce_seq", allocationSize = 50)
    private Long id;
    private String name;
    private BigDecimal cost;
    @OneToMany(mappedBy = "sauce")
    protected List<SauceOrder> sauces = new ArrayList<>();

}
