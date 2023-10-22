package by.academypvt.repository.impl;

import by.academypvt.connection.HibernateJavaConfig;
import by.academypvt.domain.entity.User;
import by.academypvt.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class UserRepositoryHibernate implements UserRepository {
    private final SessionFactory sessionFactory;
    public UserRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public User findUserById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUserById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.getTransaction().begin();
        session.remove(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> updateUsers() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select u from User u");
        return (List<User>) query.getResultList();
    }
}
