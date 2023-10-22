package by.academypvt.repository.impl;

import by.academypvt.connection.HibernateJavaConfig;
import by.academypvt.domain.entity.Pizza;
import by.academypvt.repository.PizzaRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class PizzaRepositoryHibernate implements PizzaRepository {
    private final SessionFactory sessionFactory;
    public PizzaRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public Pizza findPizzaById(Long id) {
        Session session = sessionFactory.openSession();
        Pizza pizza = session.get(Pizza.class, id);
        session.close();
        return pizza;
    }

    @Override
    public void addPizza(Pizza pizza) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(pizza);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deletePizzaById(Long id) {
        Session session = sessionFactory.openSession();
        Pizza pizza = session.get(Pizza.class, id);
        session.getTransaction().begin();
        session.remove(pizza);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Pizza> updatePizzas() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select p from Pizza p");
        return (List<Pizza>) query.getResultList();
    }
}
