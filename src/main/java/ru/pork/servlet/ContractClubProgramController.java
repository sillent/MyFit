package ru.pork.servlet;

import ru.pork.model.ClubProgram;
import ru.pork.model.Contracts;
import ru.pork.util.ClubProgramManager;
import ru.pork.util.ContractsManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by santa on 05.04.16.
 */
public class ContractClubProgramController extends HttpServlet {
    public ContractClubProgramController() {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int contract_id=0;
        int program_id=0;
        if (req.getParameter("contract_id")!=null) {
            if (req.getParameter("contract_id").length() > 0) {
                contract_id = getInt(req.getParameter("contract_id"));
            }
        }
        if (req.getParameter("program_id") != null) {
            if (req.getParameter("program_id").length() > 0) {
                program_id = getInt(req.getParameter("program_id"));
            }
        }
        ContractsManager contractsManager = new ContractsManager();

        ClubProgramManager clubProgramManager = new ClubProgramManager();
        ClubProgram clubProgram = clubProgramManager.findClubProgram(program_id);
        if (contractsManager.addProgram(clubProgram,contract_id)) {
            forwardIf(req, resp, "/contract/contracts_clubprogram_add_ok.jsp");
        } else {
            forwardIf(req, resp, "/contract/contracts_clubprogram_add_nok.jsp");
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
