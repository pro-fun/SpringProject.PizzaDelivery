package by.academypvt.repository.impl;

import by.academypvt.connection.HibernateJavaConfig;
import by.academypvt.repository.UserRepository;
import org.hibernate.SessionFactory;

public class UserRepositoryHibernate implements UserRepository {
    private final SessionFactory sessionFactory;
    public UserRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }
}
