package by.academypvt.domain.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "delivery", name = "sauce_order")
@org.hibernate.annotations.Immutable
public class SauceOrder {
    @Embeddable
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Id implements Serializable {
        @Column(name = "order_id")
        protected Long orderId;
        @Column(name = "sauce_id")
        protected Long sauceId;
    }

    @EmbeddedId
    protected Id id = new Id();
    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "sauce_id", insertable = false, updatable = false)
    private Sauce sauce;
    @Column(updatable = false)
    @NotNull
    private Long count;
    @Column(updatable = false)
    @NotNull
    private BigDecimal cost;

    public SauceOrder(Order order, Sauce sauce, Long count) {
        this.order = order;
        this.sauce = sauce;
        this.count = count;

        this.id.orderId = order.getId();
        this.id.sauceId = sauce.getId();

        order.getSauces().add(this);
        sauce.getSauces().add(this);
    }


}
