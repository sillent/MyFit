package ru.pork.servlet;


import ru.pork.model.ClubProgram;
import ru.pork.model.Service;
import ru.pork.util.ClubProgramManager;
import ru.pork.util.ServiceManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="clubprogramservicecontroller", urlPatterns = {"/clubprogramservice"})
public class ClubProgramServiceController extends HttpServlet {
    int program_id=0;
    int service_id=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("program_id")!=null) {
            if (req.getParameter("program_id").length() > 0) {
                program_id = getInt(req.getParameter("program_id"));
            }
        }
        if (req.getParameter("service_id") != null) {
            if (req.getParameter("service_id").length()>0) {
                service_id = getInt(req.getParameter("service_id"));
            }
        }

        ClubProgramManager clubProgramManager=new ClubProgramManager();

        ServiceManager serviceManager=new ServiceManager();
        Service service = serviceManager.findService(service_id);

        if (clubProgramManager.addService(service,program_id)) {
            forwardIf(req,resp,"/clubprogram/clubprogram_service_add_ok.jsp");
        } else {
            forwardIf(req,resp,"/clubprogram/clubprogram_service_add_nok.jsp");
        }

    }

    private int getInt(String value) {
        int ret=0;
        if (value.length()>0) {
            try {
                ret=Integer.parseInt(value);
                return ret;
            } catch (NumberFormatException n) {
                n.printStackTrace();
                ret=0;
                return ret;
            }
        } else {
            return ret;
        }
    }

    private void forwardIf(HttpServletRequest req, HttpServletResponse resp, String url)
            throws IOException, ServletException {
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req,resp);
    }
}
