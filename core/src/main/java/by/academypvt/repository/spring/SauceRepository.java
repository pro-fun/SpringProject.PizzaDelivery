package by.academypvt.repository.spring;

import by.academypvt.domain.entity.Pizza;
import by.academypvt.domain.entity.Sauce;
import by.academypvt.dto.order.Enums.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SauceRepository extends JpaRepository<Sauce, Long> {
    Sauce findByName(String name);
}
