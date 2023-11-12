//package by.academypvt;
//
//import by.academypvt.config.HibernateConfiguration;
//import by.academypvt.repository.PizzaRepository;
//import by.academypvt.repository.impl.PizzaRepositoryHibernate;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.Configuration;
//
//
//public class Main {
//    public static void main(String[] args) {
//
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
//        PizzaRepository pizzaRepository = applicationContext.getBean("pizzaRepository", PizzaRepositoryHibernate.class);
//        System.out.println(pizzaRepository.findPizzaById(1L));
//
//    }
//}