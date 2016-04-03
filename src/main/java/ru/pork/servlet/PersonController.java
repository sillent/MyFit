package ru.pork.servlet;

import ru.pork.model.Contracts;
import ru.pork.model.Person;
import ru.pork.model.ClubProgram;
import ru.pork.util.PersonManager;
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


@WebServlet(name="personcontroller", urlPatterns = {"/person"})
public class PersonController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = resp.getWriter();

        String firstName="";
        String lastName="";
        String secondName="";
        Date birthDate=new Date(0L);
        int state=0;
        int gender=0;
        long phone=0L;
        String email="unknown@localhost.localdomain";


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
        // STATE
        if (req.getParameter("state")!=null) {
            if (req.getParameter("state").length() > 0) {
                state = getstate(req.getParameter("state"));
            }
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

        // Check client exists and adding if not
        Person person =new Person(firstName,lastName,secondName,birthDate,state,gender,phone,email);
        if ( ! checkClientExist(person) ) {
            PersonManager personManager = new PersonManager();
            if (personManager.addClient(person)) {
                forwardIf(req, resp, "/person/person_add_ok.jsp");
            } else {
                forwardIf(req, resp, "/person/person_add_nok.jsp");
            }
        } else {
            forwardIf(req, resp, "/person/person_add_exist.jsp");
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
    // must be 0 or 1
    private int getstate(String request) {
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
    private int getstatus(String request) {
        int status;
        try {
            status = Integer.parseInt(request);
            return status;
        } catch (NumberFormatException n) {
            n.printStackTrace();
            return 0;
        }
    }

    private boolean checkClientExist(Person person) {
        PersonManager personManager =new PersonManager();
        Person cl= personManager.findClient(person.getPhone());
        return cl != null;
    }

    private void forwardIf(HttpServletRequest req, HttpServletResponse resp, String url)
            throws IOException, ServletException {
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req,resp);
    }


}
