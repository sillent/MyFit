package ru.pork.util;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.pork.model.Client;
import ru.pork.model.Contracts;
import ru.pork.servlet.DatabaseConfigurator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class ClientManager {
    private SessionFactory factory;


    public ClientManager() {
        try {
            factory= DatabaseConfigurator.getSessionFactory();
        } catch (HandlerException hex ) {
            hex.printStackTrace();
        }
    }




    public boolean addClient(Client client) {
        Transaction tx;
        Session session=factory.openSession();

        tx=session.beginTransaction();
        try {
            session.save(client);
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

    public List<Client> listClients() {
        Transaction tx;
        Session session=factory.openSession();

        List<Client> list = new ArrayList<Client>();
        tx=session.getTransaction();
        try {
            List getList = session.createQuery("from Client").list();
            for (Iterator iterator = getList.iterator(); iterator.hasNext(); ) {
                list.add((Client)iterator.next());
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
            Client client=session.get(Client.class, id);
            session.delete(client);
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
            Client client = session.get(Client.class, id);
            client.getContractses().add(contracts);
            session.update(client);
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

    public Client findClient(long phone) {

        Transaction tx;
        Session session=factory.openSession();
        tx=session.beginTransaction();
        try {
            List clients=session.createQuery("FROM Client where Client.phone=phone").list();
            for (Iterator<Client> iterator=clients.iterator();iterator.hasNext();) {
                Client client = (Client) iterator.next();
                if (client.getPhone()==phone) {
                    tx.commit();
                    session.close();
                    return client;
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


}
