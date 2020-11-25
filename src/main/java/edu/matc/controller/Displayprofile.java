package edu.matc.controller;


import edu.matc.entity.Donation;
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
        (urlPatterns = { "/DisplayProfiles" } )



public class Displayprofile extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        GenericDao<User> dao = DaoFactory.createDao(User.class);
        User user = dao.getById(1);

        req.setAttribute("users", user);
        logger.debug("Sending back the user..." + user);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/displayProfile.jsp");
        dispatcher.forward(req, resp);
    }

}
