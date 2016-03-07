package ru.pork.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by santa on 01.03.16.
 */
public class HibernateListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DatabaseConfigurator.getSessionFactory();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        DatabaseConfigurator.getSessionFactory().close();
    }
}
