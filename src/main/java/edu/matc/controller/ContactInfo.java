package edu.matc.controller;


import com.api.SendEmailSMTP;
import edu.matc.entity.Contact;
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
        (urlPatterns = { "/contactInfo" } )



public class ContactInfo extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Contact> genericDao = DaoFactory.createDao(Contact.class);

        Contact newContact = new Contact(req.getParameter("fname"), req.getParameter("lname"),
                req.getParameter("email"), req.getParameter("subject"), req.getParameter("message"));

        // send email to admin
        SendEmailSMTP send = new SendEmailSMTP();
        send.getInfo(req.getParameter("subject"), req.getParameter("message"));
        logger.info("Email was sent");

        // Add te contact to DB
        int newId = genericDao.insert(newContact);
        Contact contacts = genericDao.getById(newId);
        req.setAttribute("allContacts", contacts);
        logger.info("Sending back the contact/s..." + contacts);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/sumContact.jsp");
        dispatcher.forward(req, resp);
    }

}
