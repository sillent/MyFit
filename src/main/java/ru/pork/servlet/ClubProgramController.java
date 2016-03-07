package ru.pork.servlet;

import ru.pork.model.ClubProgram;
import ru.pork.util.ClubProgramManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ClubProgramController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        ClubProgram clubProgram=new ClubProgram();
        if (req.getParameter("name")!=null) {
            if (req.getParameter("name").length()>0) {
                clubProgram.setName(req.getParameter("name"));
            }
        }
        if (req.getParameter("price")!=null) {
            if (req.getParameter("price").length()>0) {
                clubProgram.setPrice(getInt(req.getParameter("price")));
            }
        }
        ClubProgramManager clubProgramManager=new ClubProgramManager();
        if (clubProgramManager.addClubProgramm(clubProgram)) {
            forwardIf(req, resp, "/clubprogram_add_ok.jsp");
        } else {
            forwardIf(req, resp, "/clubprogram_add_nok.jsp");
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
