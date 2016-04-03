package ru.pork.util;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.hibernate.*;
import ru.pork.model.Person;
import ru.pork.model.Contracts;
import ru.pork.servlet.DatabaseConfigurator;

import java.util.*;

public class PersonManager {
    private SessionFactory factory;


    public PersonManager() {
        try {
            factory= DatabaseConfigurator.getSessionFactory();
        } catch (HandlerException hex ) {
            hex.printStackTrace();
        }
    }




    public boolean addClient(Person person) {
        Transaction tx;
        Session session=factory.openSession();

        tx=session.beginTransaction();
        try {
            session.save(person);
            tx.commit();
            return true;
        } catch (HibernateException he) {
            tx.rollback();
            he.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public List<Person> listClients() {
        Transaction tx;
        Session session=factory.openSession();

        ArrayList<Person> list = new ArrayList<Person>();
        tx=session.beginTransaction();
        try {
            List lists = session.createQuery("FROM Person").list();
            for (Iterator<Person> iterator = lists.iterator(); iterator.hasNext(); ) {
                list.add(iterator.next());
            }
            tx.commit();
            session.close();
            return list;
        } catch (HibernateException he) {
            he.printStackTrace();
            tx.rollback();
            session.close();
            return null;
        }
    }

    public boolean delClient(int id) {
        Transaction tx;
        Session session=factory.openSession();
        tx=session.beginTransaction();
        try {
            Person person =session.get(Person.class, id);
            session.delete(person);
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

    public boolean addContract(Contracts contracts, int id) {
        Transaction tx;
        Session session = factory.openSession();
        tx = session.beginTransaction();
        try {
            Person person = session.get(Person.class, id);
            person.getContracts().add(contracts);
            session.update(person);
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

    public Person findClient(long phon) {
        Transaction tx;
        Session session=factory.openSession();
        tx=session.beginTransaction();
        try {
            Query q=session.createQuery("from Person P where P.phone=:phone");
            q.setParameter("phone", phon);
            List persons=q.list();
            for (Iterator<Person> iterator=persons.iterator();iterator.hasNext();) {
                Person person = iterator.next();
                if (person.getPhone()==phon) {
                    tx.commit();
                    session.close();
                    return person;
                }
            }
            tx.commit();
            session.close();
            return null;
        } catch (HibernateException he) {
            he.printStackTrace();
            tx.rollback();
            session.close();
            return null;
        }
    }
    public Person findClient(int id) {
        Transaction tx;
        Session session=factory.openSession();
        tx=session.beginTransaction();
        try {
            Person cl=session.get(Person.class,id);
            tx.commit();
            session.close();
            return  cl;
        } catch (HibernateException he) {
            he.printStackTrace();
            tx.rollback();
            session.close();
            return null;
        }
    }


}
