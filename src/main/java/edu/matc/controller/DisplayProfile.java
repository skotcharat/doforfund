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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet
        (urlPatterns = { "/displayProfiles" } )

public class DisplayProfile extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        GenericDao<User> dao = DaoFactory.createDao(User.class);

//        HttpSession session = req.getSession();
//        String myAttribute = (String) session.getAttribute("currentUserLogin");
//        logger.debug("Sending back the myAttribute..." + myAttribute);  ==> same as req.getRemoteUser()

        logger.debug("Sending back the req.getRemoteUser() is..." + req.getRemoteUser());
        List<User> users = dao.getByPropertyEqual("userName", req.getRemoteUser());

        int user_id =  users.get(0).getId();
        logger.debug("user_id is ..." + user_id);

        User user = dao.getById(user_id);

        req.setAttribute("users", user);
        logger.debug("Sending back the user is..." + user);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/displayProfile.jsp");
        dispatcher.forward(req, resp);
    }

}
