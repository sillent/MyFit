package ru.pork.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DatabaseConfigurator.getSessionFactory();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        DatabaseConfigurator.getSessionFactory().close();
    }
}
