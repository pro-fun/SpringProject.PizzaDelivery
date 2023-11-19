package by.academypvt.repository.impl;

import by.academypvt.connection.HibernateJavaConfig;
import by.academypvt.domain.entity.Ingredient;
import by.academypvt.repository.IngredientRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class IngredientRepositoryHibernate implements IngredientRepository {
    private final SessionFactory sessionFactory;
    public IngredientRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public Ingredient findIngredientById(Long id) {
        Session session = sessionFactory.openSession();
        Ingredient ingredient = session.get(Ingredient.class, id);
        session.close();
        return ingredient;
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(ingredient);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteIngredientById(Long id) {
        Session session = sessionFactory.openSession();
        Ingredient ingredient = session.get(Ingredient.class, id);
        session.getTransaction().begin();
        session.remove(ingredient);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Ingredient> updateIngredients() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select i from Ingredient i");
        return (List<Ingredient>) query.getResultList();
    }
}
