package ru.pork.servlet;

import ru.pork.model.Contracts;
import ru.pork.model.Person;
import ru.pork.util.ContractsManager;
import ru.pork.util.PersonManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name="contractcontroller", urlPatterns = {"/contract"})
public class ContractController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();

        Date creationDate=new Date();
        Date contractBegin=new Date();
        Date contractEnding=new Date();
        int status=0;
        int person_id=0;

        if (req.getParameter("contractBegin")!=null) {
            if (req.getParameter("contractBegin").length() > 0) {
                contractBegin = dateformat(req.getParameter("contractBegin"));
            }
        } else {
            contractBegin = new Date(0L);
        }

        if (req.getParameter("contractEnding")!=null) {
            if (req.getParameter("contractEnding").length() > 0) {
                contractEnding = dateformat(req.getParameter("contractEnding"));
            }
        } else {
            contractEnding = new Date(0L);
        }

        if (req.getParameter("status") != null) {
            if (req.getParameter("status").length() > 0) {
                status = getstatus(req.getParameter("status"));
            }
        } else {
            status=0;
        }

        if (req.getParameter("person_id") != null) {
            if (req.getParameter("person_id").length() > 0) {
                person_id = getid(req.getParameter("person_id"));
            }
        } else {
            person_id=0;
        }

        Contracts contracts = new Contracts(creationDate, contractBegin, contractEnding, status);
        PersonManager pmanager = new PersonManager();
        if (pmanager.addContract(contracts, person_id)) {
            forwardIf(req, resp, "/contract/contracts_clients_add_ok.jsp");
        } else {
            forwardIf(req, resp, "/contract/contracts_clients_add_nok.jsp");
        }



    }
    private Date dateformat(String request) {
        Date formatdate;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
            formatdate=format.parse(request);
            return formatdate;
        } catch (ParseException pe) {
            pe.printStackTrace();
            return new Date(0L);
        }
    }
    private int getstatus(String request) {
        int state;
        try {
            state = Integer.parseInt(request);
            if (state>1) {
                state=1;  // 1 - administrator
            }
            return state;
        } catch (NumberFormatException n) {
            n.printStackTrace();
            return 0;  // 0 - client
        }
    }
    private int getid(String request) {
        int id;
        try {
            id=Integer.parseInt(request);
            return id;
        } catch (NumberFormatException n) {
            n.printStackTrace();
            return 1;
        }
    }

    private void forwardIf(HttpServletRequest req, HttpServletResponse resp, String url)
            throws IOException, ServletException {
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req,resp);
    }



}
