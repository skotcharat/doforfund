package edu.matc.controller;


import edu.matc.entity.Event;
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
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet
        (urlPatterns = { "/displayEvent" } )

public class DisplayEvent extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        GenericDao<Event> dao = DaoFactory.createDao(Event.class);
        List<Event> allEvents = dao.getAll();

        req.setAttribute("allEvent", allEvents);
        logger.debug("Sending back the allEvents..." + allEvents);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/event.jsp");
        dispatcher.forward(req, resp);
    }

}
