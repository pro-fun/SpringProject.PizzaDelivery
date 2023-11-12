package by.academypvt.repository.spring;

import by.academypvt.domain.entity.Pizza;
import by.academypvt.dto.order.Enums.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    Pizza findByNameAndSize(String name, Size size);
}
