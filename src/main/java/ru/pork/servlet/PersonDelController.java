package ru.pork.servlet;

import ru.pork.util.PersonManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="persondelcontroller", urlPatterns = {"/person_del"})
public class PersonDelController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id")!=null) {
            if (req.getParameter("id").length()>0) {
                PersonManager pm=new PersonManager();
                if (pm.delClient(getInt(req.getParameter("id")))) {
                    forwardIf(req,resp,"/person/person_del_ok.jsp");
                } else {
                    forwardIf(req,resp,"/person/person_del_nok.jsp");
                }
            }
        }
    }

    private int getInt(String s) {
        try {
            int r=Integer.parseInt(s);
            return r;
        } catch (NumberFormatException ne) {
            ne.printStackTrace();
            return -1;
        }
    }

    private void forwardIf(HttpServletRequest req, HttpServletResponse resp, String url)
            throws IOException, ServletException {
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req,resp);
    }
}
