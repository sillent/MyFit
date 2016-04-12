package ru.pork.util;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.pork.model.Service;
import ru.pork.servlet.DatabaseConfigurator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServiceManager {
    private SessionFactory factory;

    public ServiceManager() {
        try {
            factory= DatabaseConfigurator.getSessionFactory();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    public boolean addService(Service service) {
        Transaction tx;
        Session session=factory.openSession();
        tx=session.beginTransaction();
        try {
            session.save(service);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException he) {
            he.printStackTrace();
            tx.rollback();
            session.close();
            return false;
        }
    }

    public Service findService(int id) {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();

        try {
            Service service=(Service)session.get(Service.class,id);

            tx.commit();
            session.close();
            return service;

        } catch (HibernateException he) {
            he.printStackTrace();
            tx.rollback();
            session.close();
            return null;
        }
    }
    public List<Service> listService() {
        Transaction tx;
        Session session=factory.openSession();
        tx=session.beginTransaction();
        List<Service> list=new ArrayList<Service>(0);
        try {
            List<Service> lists = session.createQuery("FROM Service").list();
            for (Iterator<Service> it = lists.iterator(); it.hasNext(); ) {
                list.add(it.next());
            }
            tx.commit();
            session.close();
            return list;
        } catch (HibernateException he) {
            he.printStackTrace();
            tx.rollback();
            session.close();
            return list;

        }
    }
}
