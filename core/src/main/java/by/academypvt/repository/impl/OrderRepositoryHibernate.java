package by.academypvt.repository.impl;

import by.academypvt.connection.HibernateJavaConfig;
import by.academypvt.domain.entity.Order;
import by.academypvt.repository.OrderRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class OrderRepositoryHibernate implements OrderRepository {
    private final SessionFactory sessionFactory;
    public OrderRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }
    @Override
    public Order findOrderById(Long id) {
        Session session = sessionFactory.openSession();
        Order order = session.get(Order.class, id);
        session.close();
        return order;
    }

    @Override
    public void addOrder(Order order) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(order);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteOrderById(Long id) {
        Session session = sessionFactory.openSession();
        Order order = session.get(Order.class, id);
        session.getTransaction().begin();
        session.remove(order);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Order> updateOrders() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select o from Order o");
        return (List<Order>) query.getResultList();
    }
}
