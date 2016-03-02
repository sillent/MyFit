package ru.pork.util;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jpa.event.internal.jpa.CallbackBuilderLegacyImpl;
import ru.pork.model.Client;
import ru.pork.servlet.DatabaseConfigurator;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by santa on 02.03.16.
 */
public class ClientManager {
    private SessionFactory factory;

    private String firstName;

    private String lastName;
    private String secondName;
    private Date birthDate;
    private int gender;
    private long phone;
    private String email;
    private String description;

    public ClientManager() {
        try {
            factory= DatabaseConfigurator.getSessionFactory();
        } catch (HandlerException hex ) {
            hex.printStackTrace();
        }
    }

    public ClientManager(String firstName, String lastName, String secondName, Date birthDate, int gender, long phone, String email, String description) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean addClient() {
        Transaction tx;
        Session session=factory.openSession();

        Client client = new Client(description,email,phone,gender,birthDate,secondName,lastName,firstName);
        try {
            tx=session.beginTransaction();
            session.save(client);
            tx.commit();
            return true;
        } catch (HibernateException he) {
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
        try {
            tx=session.getTransaction();
            List getList = session.createQuery("from Client").list();
            for (Iterator iterator = getList.iterator(); iterator.hasNext(); ) {
                list.add((Client)iterator.next());
            }
            tx.commit();
            session.close();
            return list;
        } catch (HibernateException he) {
            he.printStackTrace();
            session.close();
            return null;
        }
    }


}
