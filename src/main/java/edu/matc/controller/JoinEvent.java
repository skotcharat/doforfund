package edu.matc.controller;

import com.api.SendEmailSMTP;
import edu.matc.entity.Event;
import edu.matc.entity.Event_User;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import edu.matc.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
@WebServlet(
        urlPatterns = {"/joinEventWithId"}
)

public class JoinEvent extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.isUserInRole("user")) {
            GenericDao<User> genericDaoUser = DaoFactory.createDao(User.class);
            String currentUser = req.getRemoteUser();
            List<User> users = genericDaoUser.getByPropertyEqual("userName", currentUser);
            int id = users.get(0).getId();
            logger.info("User class ID  " + id);
            User retrievedUser = (User)genericDaoUser.getById(id);

            GenericDao<Event> genericDao = DaoFactory.createDao(Event.class);
            Event retrievedEvent = genericDao.getById(Integer.parseInt(req.getParameter("EditWithId")));
            String date = String.valueOf(retrievedEvent.getEventDate());
            String time = String.valueOf(retrievedEvent.getEventTime());
            String place = retrievedEvent.getEventPlace();
            String EventInfo = "Your event is on " + date + " @" + time+ " at " + place + "." ;
            logger.info("Integer.parseInt(req.getParameter(\"EditWithId\")  " + Integer.parseInt(req.getParameter("EditWithId")));

            retrievedUser.getEventMany().add(retrievedEvent);

            GenericDao<Event_User> genericDaoMany = DaoFactory.createDao(Event_User.class);
            Event_User eventUser = new Event_User(Integer.parseInt(req.getParameter("EditWithId")), id);
            int newId = genericDaoMany.insert(eventUser);

            // send email to the user
            SendEmailSMTP send = new SendEmailSMTP();
            send.getInfo("Thank for joining an event with us", EventInfo);
            logger.info("Email was sent");
            String message = "Thank for joining an event with us, you will receive an email to confirm your event";
            req.setAttribute("message", message);

        } else {
            String message = "Please sign in to join an event";
            req.setAttribute("message", message);
        }



        RequestDispatcher dispatcher = req.getRequestDispatcher("/joinAnEvent.jsp");
        dispatcher.forward(req, resp);
    }

}

