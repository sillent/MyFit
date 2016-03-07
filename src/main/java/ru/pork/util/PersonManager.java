package ru.pork.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import ru.pork.model.AbonCard;
import ru.pork.servlet.DatabaseConfigurator;

import java.util.Date;

/**
 * Created by santa on 01.03.16.
 */
public class PersonManager {
    private String firstName;
    private String lastName;
    private String secondName;
    private Date birthDate;
    private int gender;
    private long phone;
    private String email;
    private String description;
    private AbonCard abonCard;

    private Date begin_date;
    private Date expire_date;


    private Session session;
    public PersonManager() {}

    public PersonManager(String firstName, String lastName, String secondName, Date birthDate, int gender, long phone, String email, String description, AbonCard abonCard, Date begin_date, Date expire_date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.abonCard = abonCard;
        this.begin_date = begin_date;
        this.expire_date = expire_date;
        try {
            session = DatabaseConfigurator.getSessionFactory().openSession();
        }catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }

    public boolean addPerson() {
        return true;
    }
}
