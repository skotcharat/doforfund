package edu.matc.controller;

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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/attendEventWithId"}
)

public class AttendEventWithId extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get all user in the event
        GenericDao<Event_User> dao = DaoFactory.createDao(Event_User.class);
        List<Event_User> usersInEvent = dao.getByPropertyEqual("events_id", req.getParameter("AttendWithId"));
        int amountUser = usersInEvent.size();
        req.setAttribute("amountUsers", amountUser);
        logger.debug("Sending back the amountUsers..." + amountUser);

        User retriveUser;
        List<User> user = new ArrayList<>();
        for(int i = 0; i < amountUser;i++) {
            Event_User retrievedEventUsers = (Event_User)dao.getById(usersInEvent.get(i).getId());
            int userId = retrievedEventUsers.getUser_id();
            GenericDao<User> daoUser = DaoFactory.createDao(User.class);
            retriveUser = daoUser.getById(userId);
            user.add(retriveUser);
        }
        req.setAttribute("users", user);
        logger.debug("Sending back the users..." + user);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/attendEvent.jsp");
        dispatcher.forward(req, resp);
    }
}


