package ru.pork.util;

import org.hibernate.*;
import ru.pork.model.ClubProgram;
import ru.pork.servlet.DatabaseConfigurator;

import java.util.Iterator;
import java.util.List;

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

    public ClubProgram findClubProgram(String name) {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        ClubProgram program;
        try {
            Query q=session.createQuery("from ClubProgram  CP where CP.name = :name");
            q.setParameter("name", name);
            List list=q.list();

            for (Iterator<ClubProgram> iterator=list.iterator(); iterator.hasNext();) {
                program=iterator.next();
                if (program.getName().equals(name)) {
                    tx.commit();
                    session.close();
                    return program;
                }
            }
            tx.commit();
            session.close();
        } catch (HibernateException he) {
            he.printStackTrace();
            tx.rollback();
            session.close();
            return null;
        }
        return null;
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
