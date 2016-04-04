package ru.pork.servlet;

import ru.pork.model.ClubProgram;
import ru.pork.util.ClubProgramManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@WebServlet(name="clubprogramcontroller", urlPatterns = { "/clubprogram"})
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

        // Check program exist before adding to DB
        if (checkProgramExist(clubProgram)) {
            forwardIf(req,resp, "/clubprogram_add_exist.jsp");
        } else {

            // Adding program to DB
            if (clubProgramManager.addClubProgramm(clubProgram)) {
                forwardIf(req, resp, "/clubprogram_add_ok.jsp");
            } else {
                forwardIf(req, resp, "/clubprogram_add_nok.jsp");
            }
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

    public boolean checkProgramExist(ClubProgram program) {
        ClubProgramManager manager=new ClubProgramManager();
        ClubProgram program1=manager.findClubProgram(program.getName());
        if (program1!=null) {
            return true;
        } else
            return false;
    }

    private void forwardIf(HttpServletRequest req, HttpServletResponse resp, String url)
            throws IOException, ServletException {
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req,resp);
    }
}
