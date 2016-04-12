package ru.pork.servlet;

import ru.pork.model.Service;
import ru.pork.util.ServiceManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="servicecontroller", urlPatterns = {"/service"})
public class ServiceControl extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if (req.getParameter("name") != null) {
                if (req.getParameter("name").length() > 0) {
                    Service service = new Service(req.getParameter("name"));
                    ServiceManager serviceManager = new ServiceManager();
                    if (serviceManager.addService(service)) {
                        forwardIf(req, resp, "/service/service_add_ok.jsp");
                    } else {
                        forwardIf(req, resp, "/service/service_add_nok.jsp");
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
