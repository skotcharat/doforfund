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

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet
        (urlPatterns = { "/signupInfo" } )



public class SignupInfo extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




        GenericDao<User> genericDao = DaoFactory.createDao(User.class);

        User newUser = new User(req.getParameter("fname"), req.getParameter("lname"),
                req.getParameter("username"), req.getParameter("password"), req.getParameter("email"));

        String userRoleName = "user";
        String userName = req.getParameter("username");
        UserRole userRoles = new UserRole(userRoleName, userName, newUser);

        newUser.addUserRoles(userRoles);
        int id = genericDao.insert(newUser);
        User insertedUser = (User)genericDao.getById(id);

        User user = genericDao.getById(id);
        req.setAttribute("newUser", user);
        logger.debug("Sending back the User..." + user);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }

}
