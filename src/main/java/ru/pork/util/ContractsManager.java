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

    private Date creationDate;
    private Date contractBegin;
    private Date contractEnding;
    private int status;

    public ContractsManager() {
        try {
            factory= DatabaseConfigurator.getSessionFactory();
        } catch (HibernateException he) {
            he.printStackTrace();
            factory=null;
        }
    }

    public ContractsManager(Date creationDate, Date contractBegin, Date contractEnding, int status) {
        this();
        this.creationDate=creationDate;
        this.contractBegin=contractBegin;
        this.contractEnding=contractEnding;
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getContractBegin() {
        return contractBegin;
    }

    public void setContractBegin(Date contractBegin) {
        this.contractBegin = contractBegin;
    }

    public Date getContractEnding() {
        return contractEnding;
    }

    public void setContractEnding(Date contractEnding) {
        this.contractEnding = contractEnding;
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
            Contracts contract = new Contracts(creationDate, contractBegin, contractEnding, status);
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
