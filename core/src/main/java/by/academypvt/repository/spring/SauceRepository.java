package by.academypvt.repository.spring;

import by.academypvt.domain.entity.Sauce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SauceRepository extends JpaRepository<Sauce, Long> {
    Sauce findByName(String name);
}
