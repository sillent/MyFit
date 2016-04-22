package ru.pork.servlet;


import ru.pork.util.ServiceManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="servicedelcontroller", urlPatterns = {"/service_del"})
public class ServiceDelController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("service_id")!=null) {
            if (req.getParameter("service_id").length()>0) {
                ServiceManager sm=new ServiceManager();
                if (sm.delService(getInt(req.getParameter("service_id")))) {
                    forwardIf(req,resp,"/service/service_del_ok.jsp");
                } else {
                    forwardIf(req,resp,"/service/service_del_nok.jsp");
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
