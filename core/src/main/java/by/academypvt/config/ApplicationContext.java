package by.academypvt.config;

import by.academypvt.repository.UserRepository;
import by.academypvt.repository.impl.UserRepositoryHibernate;
import by.academypvt.service.UserService;
import by.academypvt.service.impl.UserServiceJpa;

public class ApplicationContext {
    private static ApplicationContext applicationContext;
    private final UserRepository userRepository;
    private final UserService userService;


    private ApplicationContext() {
        userRepository = new UserRepositoryHibernate();
        userService = new UserServiceJpa(userRepository);
    }

    public static ApplicationContext getInstance() {
        if (applicationContext == null) {
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public UserService getUserService() {
        return userService;
    }
}
