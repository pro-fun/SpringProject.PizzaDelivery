package by.academypvt.repository.impl;

import by.academypvt.connection.HibernateJavaConfig;
import by.academypvt.domain.entity.Sauce;
import by.academypvt.repository.SauceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class SauceRepositoryHibernate implements SauceRepository {
    private final SessionFactory sessionFactory;
    public SauceRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public Sauce findSauceById(Long id) {
        Session session = sessionFactory.openSession();
        Sauce sauce = session.get(Sauce.class, id);
        session.close();
        return sauce;
    }

    @Override
    public void addSauce(Sauce sauce) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(sauce);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteSauceById(Long id) {
        Session session = sessionFactory.openSession();
        Sauce sauce = session.get(Sauce.class, id);
        session.getTransaction().begin();
        session.remove(sauce);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Sauce> updateSauces() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select s from Sauce s");
        return (List<Sauce>) query.getResultList();
    }
}
