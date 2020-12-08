package edu.matc.controller;

import edu.matc.entity.Event;
import edu.matc.entity.Event_User;
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
@WebServlet(
        urlPatterns = {"/joinEventWithId"}
)

public class JoinEvent extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> genericDaoUser = DaoFactory.createDao(User.class);

        logger.info("The logged in user: " + req.getRemoteUser() + "has a role of admin: " + req.isUserInRole("admin"));

        String currentUser = req.getRemoteUser();
        List<User> users = genericDaoUser.getByPropertyEqual("userName", currentUser);
        int id = users.get(0).getId();
        logger.info("User class ID  " + id);
        User retrievedUser = (User)genericDaoUser.getById(id);

       GenericDao<Event> genericDao = DaoFactory.createDao(Event.class);
        Event retrievedEvent = genericDao.getById(Integer.parseInt(req.getParameter("EditWithId")));

        logger.info("Integer.parseInt(req.getParameter(\"EditWithId\")  " + Integer.parseInt(req.getParameter("EditWithId")));

        Event_User eventUser = new Event_User(Integer.parseInt(req.getParameter("EditWithId")), id);
        retrievedUser.addEvent(retrievedEvent);


//        GenericDao<Event_User> genericDaoMany = DaoFactory.createDao(Event_User.class);
//        int id2 = genericDaoMany.insert(retrievedUser);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/joinAnEvent.jsp");
        dispatcher.forward(req, resp);
    }

}

