package edu.matc.controller;

import edu.matc.entity.Contact;
import edu.matc.entity.Event;
import edu.matc.entity.User;
import edu.matc.entity.UserRole;
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
import java.io.IOException;
/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet
        (urlPatterns = { "/addEventAction" } )
public class AddEventAction extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Event> genericDao = DaoFactory.createDao(Event.class);

        Event newEvent = new Event(req.getParameter("eventName"), req.getParameter("eventPlace"),
                req.getParameter("eventDate"), req.getParameter("eventTime"), req.getParameter("eventDescription"));


        int newId = genericDao.insert(newEvent);

        Event events  = genericDao.getById(newId);
        req.setAttribute("eventInfo", events);
        logger.debug("Sending back the events..." + events);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/addEventSuccess.jsp");
        dispatcher.forward(req, resp);
    }
}
