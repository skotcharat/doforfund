package edu.matc.controller;


import edu.matc.entity.Contact;
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
import java.util.Properties;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet
        (urlPatterns = { "/signupInfo" } )



public class SignupInfo extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties;

    // constructor
    public SignupInfo() {
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

        User newUser = new User(req.getParameter("fname"), req.getParameter("lname"),
                req.getParameter("username"), req.getParameter("password"), req.getParameter("email"));

        String userRoleName = "user";
        String userName = req.getParameter("username");
        UserRole userRoles = new UserRole(userRoleName, userName, newUser);

        newUser.addUserRoles(userRoles);
        int id = genericDao.insert(newUser);
        User insertedUser = (User)genericDao.getById(id);

        resp.sendRedirect(properties.getProperty("url") + "/loginAction");
    }

}
