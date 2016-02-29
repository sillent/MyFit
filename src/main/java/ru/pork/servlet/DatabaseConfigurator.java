package ru.pork.servlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by santa on 29.02.16.
 */
public class DatabaseConfigurator {

    private static SessionFactory factory;
    static {
        try {
            factory=new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Error creating static Database Handler: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory() {
        return factory;
    }

}
