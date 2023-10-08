package by.academypvt.connection;

import by.academypvt.domain.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateJavaConfig {

    private final static Configuration configuration;
    private final static StandardServiceRegistryBuilder serviceRegistryBuilder;
    static {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.use_sql_comments", "true");
        properties.setProperty("hibernate.format_sql","true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/PizzaDelivery");
        properties.setProperty("hibernate.connection.username", "postgres");
        properties.setProperty("hibernate.connection.password", "sa");
        properties.setProperty("hibernate.show_sql","true");
        configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Order.class);
        configuration.addAnnotatedClass(Position.class);
        configuration.addAnnotatedClass(Pizza.class);
        configuration.addAnnotatedClass(Sauce.class);
        configuration.addAnnotatedClass(Ingredient.class);

        serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(properties);
         }
         public static SessionFactory getSessionFactory(){
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
        return sessionFactory;
         }
}
