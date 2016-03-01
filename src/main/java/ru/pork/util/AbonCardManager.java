package ru.pork.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.pork.model.AbonCard;
import ru.pork.servlet.DatabaseConfigurator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AbonCardManager {
    String desc;
    int price;
    private static SessionFactory factory;
    public AbonCardManager(String desc, int price) {
        this.desc=desc;
        this.price=price;
        try {
            factory=DatabaseConfigurator.getSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError();
        }
    }
    public AbonCardManager() {
        try {
            factory=DatabaseConfigurator.getSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError();
        }
    }


    public boolean addAbonCard() {
        boolean retval;
        Session session=factory.openSession();
        Transaction tx=null;
        AbonCard card = new AbonCard(desc, price);
        try {
            tx = session.beginTransaction();
            session.save(card);
            tx.commit();
            return true;
        } catch (HibernateException he) {
            he.printStackTrace();
            if (tx!=null) tx.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public List<AbonCard> listAllAbonCards() {
        Session session=factory.openSession();
        Transaction tx=null;
        ArrayList<AbonCard> cards = new ArrayList<AbonCard>();
        tx=session.beginTransaction();
        List aboncards=session.createQuery("FROM AbonCard ").list();
        for (Iterator iterator = aboncards.iterator(); iterator.hasNext(); ) {
            AbonCard card=(AbonCard)iterator.next();
            cards.add(card);
        }
        tx.commit();
        session.close();
        return aboncards;
    }

}
