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
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by santa on 24.02.16.
 */
public class AbonCardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        SessionFactory factory=DatabaseConfigurator.getSessionFactory();
//        Session session=factory.openSession();
        PrintWriter pw=resp.getWriter();

        pw.println(req.getParameter("price"));
        pw.println(req.getParameter("description"));

    }
}
