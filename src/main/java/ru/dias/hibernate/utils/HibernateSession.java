package ru.dias.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {

    private static SessionFactory sessionFactory = configureSessionFactory();
    private static final String PATH_CONFIGURATION_FILE = "hibernate.cfg.xml";

    public static SessionFactory configureSessionFactory() {
        SessionFactory factory = new Configuration()
                .configure(PATH_CONFIGURATION_FILE)
                .buildSessionFactory();
        return factory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
