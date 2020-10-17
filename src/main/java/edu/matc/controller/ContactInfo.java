package edu.matc.controller;


import edu.matc.entity.Contact;
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
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet
        (urlPatterns = { "/recieveContact" } )



public class ContactInfo extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




        GenericDao<Contact> genericDao = DaoFactory.createDao(Contact.class);

        Contact newContact = new Contact(req.getParameter("fname"), req.getParameter("lname"),
                req.getParameter("email"), req.getParameter("subject"), req.getParameter("message"));


        int newId = genericDao.insert(newContact);

        Contact contacts = genericDao.getById(newId);
        req.setAttribute("allContacts", contacts);
        logger.debug("Sending back the contact/s..." + contacts);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/sumContact.jsp");
        dispatcher.forward(req, resp);
    }

}
