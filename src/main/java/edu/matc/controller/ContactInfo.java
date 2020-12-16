package edu.matc.controller;


import com.api.SendEmailSMTP;
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
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.List;


import javax.validation.Validator;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet
        (urlPatterns = { "/contactInfo" } )

public class ContactInfo extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    //private static Validator validator;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<User> genericDaoUser = DaoFactory.createDao(User.class);
        GenericDao<Contact> genericDao = DaoFactory.createDao(Contact.class);

        if(req.isUserInRole("user")) {
            String username = req.getRemoteUser();
            logger.info("ContactInfo class req.getRemoteUser()  " + req.getRemoteUser());

            List<User> users = genericDaoUser.getByPropertyEqual("userName", username);
            int id = users.get(0).getId();
            logger.info("ContactInfo class ID  " + id);

            User retrievedUser = (User)genericDaoUser.getById(id);
            logger.info("ContactInfo class retrievedUser  " + retrievedUser);

            Contact newContact = new Contact(req.getParameter("fname"),
                    req.getParameter("lname"),
                    req.getParameter("email"),
                    req.getParameter("subject"),
                    req.getParameter("message"), username, retrievedUser);
            logger.info("ContactInfo class newContact  " + newContact);

            /**
             *  Trying to implement the validation message, but it is not working
             */
//          ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//          validator = factory.getValidator();

//          String messages =  validator.validateProperty( newContact, "email" ).iterator().next().getMessage();
//          req.setAttribute("messages", messages);


            // Add te contact to DB
            retrievedUser.addContact(newContact);

            int newId = genericDao.insert(newContact);

            Contact contacts = genericDao.getById(newId);
            req.setAttribute("allContacts", contacts);
            logger.info("Sending back the contact/s..." + contacts);
        }
        else {
            Contact newContact = new Contact(req.getParameter("fname"),
                    req.getParameter("lname"),
                    req.getParameter("email"),
                    req.getParameter("subject"),
                    req.getParameter("message"));
            // Add te contact to DB
            int newId = genericDao.insert(newContact);

            Contact contacts = genericDao.getById(newId);
            req.setAttribute("allContacts", contacts);
            logger.info("Sending back the contact/s..." + contacts);
        }

        // send email to admin
        SendEmailSMTP send = new SendEmailSMTP();
        send.getInfo(req.getParameter("subject"), req.getParameter("message"));
        logger.info("Email was sent");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/sumContact.jsp");
        dispatcher.forward(req, resp);
    }

}
