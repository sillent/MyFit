package ru.pork.servlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pork.model.AbonCard;
import ru.pork.model.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by santa on 24.02.16.
 */
public class AbonCardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();

        session.beginTransaction();
        AbonCard card1=new AbonCard((byte)0,"Standard",new Date(), new Date(),100,(byte)0,0);
        long phone = 79265105227L;
        Person person1 = new Person("Dima", "Ulyanov", "Mikhailovich", new Date(), (byte) 1, phone, "siilent1987@yahoo.com",
                "First client");
//        card1.setPersons(new HashSet<Person>());

//        card1.getPersons().add(person1);

        person1.setAbonCard(card1);
        session.save(card1);
        session.save(person1);

        session.getTransaction().commit();
        session.close();

    }
}
