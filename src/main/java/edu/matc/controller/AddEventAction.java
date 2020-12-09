package edu.matc.controller;

import edu.matc.entity.Contact;
import edu.matc.entity.Event;
import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.persistence.GenericDao;
import edu.matc.util.DaoFactory;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet
        (urlPatterns = { "/addEventAction" } )
public class AddEventAction extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Event> genericDao = DaoFactory.createDao(Event.class);
        LocalDate chosenDate = LocalDate.parse(req.getParameter("eventDate"));
        LocalTime chosenTime = LocalTime.parse(req.getParameter("eventTime"));

        Event newEvent = new Event(req.getParameter("eventName"), req.getParameter("eventPlace"),
                chosenDate, chosenTime, req.getParameter("eventDescription"));

        int newId = genericDao.insert(newEvent);
        Event insertedEvent = (Event)genericDao.getById(newId);
        logger.info("insertedEvent" + insertedEvent);

        resp.sendRedirect("http://localhost:8080/DOFORFUND_war/displayEvent");

    }

}
