package edu.matc.controller;

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
        urlPatterns = {"/editProfileAction"}
)

public class EditProfileAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties;

    // constructor
    public EditProfileAction() {
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

        GenericDao<User> genericDao = DaoFactory.createDao(User.class);
        User userBeforeUpdate = genericDao.getById(Integer.parseInt(req.getParameter("ParameterId")));
        userBeforeUpdate.setFirstName(req.getParameter("fname"));
        userBeforeUpdate.setLastName(req.getParameter("lname"));
        userBeforeUpdate.setUserName(req.getParameter("username"));
        userBeforeUpdate.setPassword(req.getParameter("password"));
        userBeforeUpdate.setEmail(req.getParameter("email"));
        genericDao.saveOrUpdate(userBeforeUpdate);

        if(req.isUserInRole("admin")) {
            resp.sendRedirect(properties.getProperty("url") + "/adminPage");
        } else {
            resp.sendRedirect(properties.getProperty("url") + "/displayProfiles");
        }

    }
}

