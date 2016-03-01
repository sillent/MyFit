package ru.pork.servlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pork.model.AbonCard;
import ru.pork.model.Person;
import ru.pork.util.AbonCardManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


/**
 * Created by santa on 24.02.16.
 */
public class AbonCardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        String desc = null;
        Integer price = null;
        if (req.getParameter("description").length() > 0) {
            desc = req.getParameter("description");
        }
        if (req.getParameter("price").length() > 0) {
            price = Integer.valueOf(req.getParameter("price"));
        }
        if (price != null && desc != null) {
            AbonCardManager abcmanager = new AbonCardManager(desc, price);
            if (abcmanager.addAbonCard()) {
                pw.println("<H1>Success</H1></center>");
            } else {
                pw.println("<H1>Fail</H1>");
            }
        }
        pw.println("<a href=/>Назад</a>");
    }
}
