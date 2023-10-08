package by.academypvt.repository.impl;

import by.academypvt.connection.HibernateJavaConfig;
import by.academypvt.domain.entity.Position;
import by.academypvt.repository.PositionRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class PositionRepositoryHibernate implements PositionRepository {
    private final SessionFactory sessionFactory;
    public PositionRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public Position findPositionById(Long id) {
        Session session = sessionFactory.openSession();
        Position position = session.get(Position.class, id);
        session.close();
        return position;
    }

    @Override
    public void addPosition(Position position) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(position);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deletePositionById(Long id) {
        Session session = sessionFactory.openSession();
        Position position = session.get(Position.class, id);
        session.getTransaction().begin();
        session.remove(position);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Position> updatePositions() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select p from Position p");
        return (List<Position>) query.getResultList();
    }
}
