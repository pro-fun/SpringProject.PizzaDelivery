package by.academypvt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("by.academypvt.repository")
public class PizzaDeliveryStart {
    public static void main(String[] args) {
        SpringApplication.run(PizzaDeliveryStart.class, args);
    }
}
