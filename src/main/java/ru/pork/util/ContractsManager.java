package ru.pork.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.pork.model.Contracts;
import ru.pork.servlet.DatabaseConfigurator;

import java.util.Date;
import java.util.List;

/**
 * Created by santa on 02.03.16.
 */
public class ContractsManager {
    private SessionFactory factory;

    private Date startDate;
    private int daysActive;
    private int status;

    public ContractsManager() {
        try {
            factory= DatabaseConfigurator.getSessionFactory();
        } catch (HibernateException he) {
            he.printStackTrace();
            factory=null;
        }
    }

    public ContractsManager(Date startDate, int daysActive, int status) {
        this();
        this.startDate = startDate;
        this.daysActive = daysActive;
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDaysActive() {
        return daysActive;
    }

    public void setDaysActive(int daysActive) {
        this.daysActive = daysActive;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public boolean addContract() {
        Transaction tx;
        Session session = factory.openSession();
        tx=session.beginTransaction();

        try {
            Contracts contract = new Contracts(startDate, daysActive, status);
            session.save(contract);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException he) {
            tx.rollback();
            he.printStackTrace();
            session.close();
            return false;
        }
    }

    public List<Contracts> listContracts() {
        Transaction tx;
        Session session=factory.openSession();

        tx=session.beginTransaction();
        try {
            List<Contracts> list;
            list=session.createQuery("FROM Contracts").list();
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

}
