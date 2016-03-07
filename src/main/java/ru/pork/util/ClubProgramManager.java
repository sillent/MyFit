package ru.pork.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.pork.model.ClubProgram;
import ru.pork.servlet.DatabaseConfigurator;

import java.util.List;

/**
 * Created by santa on 03.03.16.
 */
public class ClubProgramManager {
    SessionFactory factory;

    public ClubProgramManager() {
        try {
            factory= DatabaseConfigurator.getSessionFactory();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }


    public boolean addClubProgramm(ClubProgram program){
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();

        try {
            session.save(program);
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

    public boolean delClubProgram(ClubProgram program) {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();

        try {
            session.delete(program);
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

    public List<ClubProgram> listClubProgram() {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        List<ClubProgram> list;
        try {
            list=session.createQuery("FROM ClubProgram").list();
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

    public boolean updateClubProgram(ClubProgram program) {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();

        try {
            ClubProgram program1=(ClubProgram)session.get(program.getClass().toString(),program.getId());
            session.update(program1);
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

    public ClubProgram findClubProgram(int id) {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();

        try {
            ClubProgram program=(ClubProgram)session.get(ClubProgram.class,id);

            tx.commit();
            session.close();
            return program;

        } catch (HibernateException he) {
            he.printStackTrace();
            tx.rollback();
            session.close();
            return null;
        }
    }
}
