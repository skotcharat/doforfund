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
import java.util.Properties;

@WebServlet(
        urlPatterns = {"/editContactAction"}
)

public class EditContactAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties;

    // constructor
    public EditContactAction() {
        loadProperties();
    }

    // load properties
    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/url.properties"));
        } catch (IOException ioe) {
            logger.error("Database.loadProperties()...Cannot load the properties file.." + ioe);
        } catch (Exception e) {
            logger.error("Database.loadProperties()..." + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Contact> genericDao = DaoFactory.createDao(Contact.class);
        Contact contactBeforeUpdate = genericDao.getById(Integer.parseInt(req.getParameter("ParameterId")));
        contactBeforeUpdate.setFirstname(req.getParameter("fname"));
        contactBeforeUpdate.setLastname(req.getParameter("lname"));
        contactBeforeUpdate.setEmail(req.getParameter("email"));
        contactBeforeUpdate.setSubject(req.getParameter("subject"));
        contactBeforeUpdate.setMessage(req.getParameter("message"));
        genericDao.saveOrUpdate(contactBeforeUpdate);

        resp.sendRedirect(properties.getProperty("url") + "/adminPage");
    }
}

