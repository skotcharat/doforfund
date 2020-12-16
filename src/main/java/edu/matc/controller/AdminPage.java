package edu.matc.controller;


import edu.matc.entity.*;
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
        (urlPatterns = { "/adminPage" } )

public class AdminPage extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get all users
        GenericDao<User> daoUser = DaoFactory.createDao(User.class);
        List<User> allUsers = daoUser.getAll();
        req.setAttribute("users", allUsers);
        logger.debug("Sending back the user/s..." + allUsers);

        // get all events
        GenericDao<Event> daoEvent = DaoFactory.createDao(Event.class);
        List<Event> allEvents = daoEvent.getAll();
        req.setAttribute("events", allEvents);
        logger.debug("Sending back the event/s..." + allEvents);

        // get all donations
        GenericDao<Donation> daoDonation = DaoFactory.createDao(Donation.class);
        List<Donation> allDonations = daoDonation.getAll();
        req.setAttribute("donations", allDonations);
        logger.debug("Sending back the donation/s..." + allDonations);

        // get all contacts
        GenericDao<Contact> daoContact = DaoFactory.createDao(Contact.class);
        List<Contact> allContacts = daoContact.getAll();
        req.setAttribute("contacts", allContacts);
        logger.debug("Sending back the contact/s..." + allContacts);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(req, resp);
    }

}
