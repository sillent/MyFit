package ru.pork.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by santa on 04.03.16.
 */
public class ClientController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();

        String firstName;
        String lastName;
        String secondName;
        Date birthDate;
        int gender;
        long phone;
        String email;
        String description;

        if (req.getParameter("firstName").length() > 0) {
            firstName = req.getParameter("firstName");
        }
        if (req.getParameter("lastName").length()>0) {
            lastName=req.getParameter("lastName");
        }
        if (req.getParameter("secondName").length()>0) {
            secondName=req.getParameter("secondName");
        }
        if (req.getParameter("birthDate").length()>0) {
            DateFormat format=new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
            try {
                birthDate = format.parse(req.getParameter("birthdate"));
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        }
        if (req.getParameter("gender").length()>0) {
            gender=Integer.getInteger(req.getParameter("gender")).intValue();
        } else {
            gender=0; // male
        }


    }
}
