package by.academypvt.repository.impl;

import by.academypvt.connection.HibernateJavaConfig;
import by.academypvt.domain.entity.Order;
import by.academypvt.domain.entity.User;
import by.academypvt.repository.OrderRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
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

    @Override
    public List<Order> findOrdersForUser(User user) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
        Root<Order> order = criteriaQuery.from(Order.class);
        criteriaQuery.select(order).where(order.get("user").in(user));
        List orders = entityManager.createQuery(criteriaQuery).getResultList();
        return orders;
    }
}
