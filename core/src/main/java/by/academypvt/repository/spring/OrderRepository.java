package by.academypvt.repository.spring;

import by.academypvt.domain.entity.Order;
import by.academypvt.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.userId=:userId")
    List<Order> findByUserId(@Param("userId") User userId);
}
