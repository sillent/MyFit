package ru.pork.util;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.hibernate.*;
import ru.pork.model.Client;
import ru.pork.model.Contracts;
import ru.pork.servlet.DatabaseConfigurator;

import java.util.*;


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
            if (client.getProgram()==null) {
                return false;
            } else {
                session.save(client);
                tx.commit();
                return true;
            }
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

        ArrayList<Client> list = new ArrayList<Client>();
        tx=session.beginTransaction();
        try {
            List lists = session.createQuery("FROM Client ").list();
            for (Iterator<Client> iterator = lists.iterator(); iterator.hasNext(); ) {
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

    public Client findClient(long phon) {
        Transaction tx;
        Session session=factory.openSession();
        tx=session.beginTransaction();
        try {
            Query q=session.createQuery("from Client  C where C.phone=:phone");
            q.setParameter("phone", phon);
            List clients=q.list();
            for (Iterator<Client> iterator=clients.iterator();iterator.hasNext();) {
                Client client = iterator.next();
                if (client.getPhone()==phon) {
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
    public Client findClient(int id) {
        Transaction tx;
        Session session=factory.openSession();
        tx=session.beginTransaction();
        try {
            Client cl=session.get(Client.class,id);
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
