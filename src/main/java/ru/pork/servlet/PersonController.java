package ru.pork.servlet;

import ru.pork.model.Person;
import ru.pork.model.ClubProgram;
import ru.pork.util.ClientManager;
import ru.pork.util.ClubProgramManager;

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


@WebServlet(name="clientcontroller", urlPatterns = {"/client"})
public class PersonController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();

        String firstName="";
        String lastName="";
        String secondName="";
        Date birthDate=new Date(0L);
        int gender=0;
        long phone=0L;
        String email="unknown@localhost.localdomain";
        String description="";
        ClubProgram program=null;

        // FIRSTNAME
        if (req.getParameter("firstName")!=null) {
            if (req.getParameter("firstName").length() > 0) {
                firstName = req.getParameter("firstName");
            }
        } else {
            firstName = "unknown";
        }
        // LASTNAME
        if (req.getParameter("lastName")!=null) {
            if (req.getParameter("lastName").length() > 0) {
                lastName = req.getParameter("lastName");
            }
        } else {
            lastName = "unknown";
        }
        // SECONDNAME
        if (req.getParameter("secondName")!=null) {
            if (req.getParameter("secondName").length() > 0) {
                secondName = req.getParameter("secondName");
            }
        } else {
            secondName = "unknown";
        }
        //
        if (req.getParameter("birthDate")!=null) {
            if (req.getParameter("birthDate").length() > 0) {
                birthDate = birthdateformat(req.getParameter("birthDate"));
            }
        } else {
            birthDate = new Date(0L);
        }
        // GENDER
        if (req.getParameter("gender")!=null) {
            if (req.getParameter("gender").length() > 0) {
                gender = getgender(req.getParameter("gender"));
            }
        } else {
            gender = 0; // male
        }
        // PHONE
        if (req.getParameter("phone")!=null) {
            if (req.getParameter("phone").length() > 0) {
                phone = getphone(req.getParameter("phone"));
            }
        } else {
            phone = 0L;
        }
        // EMAIL
        if (req.getParameter("email")!=null) {
            if (req.getParameter("email").length() > 0) {
                email = req.getParameter("email");
            }
        } else {
            email = "unknown@localhost.localdomain";
        }
        // DESCRIPTION
        if (req.getParameter("description")!=null) {
            if (req.getParameter("description").length() > 0) {
                description = req.getParameter("description");
            }
        } else {
            description = "";
        }
        if (req.getParameter("clubprogram")!=null) {
            if (req.getParameter("clubprogram").length()>0) {
                ClubProgramManager manager=new ClubProgramManager();
                int id=Integer.parseInt(req.getParameter("clubprogram"));
                program=manager.findClubProgram(id);
            } else {
                program=null;
            }
        }

        // Check client exists and adding if not
        Person person =new Person(description,email,phone,gender,birthDate,secondName,lastName,firstName,program);
        if ( ! checkClientExist(person) ) {
            ClientManager clientManager = new ClientManager();
            if (clientManager.addClient(person)) {
                forwardIf(req, resp, "/client_add_ok.jsp");
            } else {
                forwardIf(req, resp, "/client_add_nok.jsp");
            }
        }



    }


    private Date birthdateformat(String request) {
        Date birthDate;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthDate = format.parse(request);
            return birthDate;
        } catch (ParseException pe) {
            pe.printStackTrace();
            return new Date(0L);
        }
    }

    private int getgender(String request) {
        int gender;
        try {
            gender=Integer.parseInt(request);
            return gender;
        } catch (NumberFormatException n) {
            n.printStackTrace();
            return 0;  // 0 - male
        }
    }
    private long getphone(String request) {
        long phone;
        try {
            phone=Long.parseLong(request);
            return phone;
        } catch (NumberFormatException n) {
            n.printStackTrace();
            return 0L;
        }
    }

    private boolean checkClientExist(Person person) {
        ClientManager clientManager=new ClientManager();
        Person cl=clientManager.findClient(person.getPhone());
        if (cl!=null) {
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
