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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(
        urlPatterns = {"/cancelEventWithId"}
)

public class CancleEventWithId extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Event_User> genericDao = DaoFactory.createDao(Event_User.class);
        GenericDao<User> genericDaoUser = DaoFactory.createDao(User.class);

        List<User> users = genericDaoUser.getByPropertyEqual("userName", req.getRemoteUser());
        int id = users.get(0).getId();

        Map<String, Object> propsAndValues = new HashMap<>();
        propsAndValues.put("user_id", id);
        propsAndValues.put("events_id", req.getParameter("CancelWithId"));

        List<Event_User> eventUsers = genericDao.findByPropertyEqual(propsAndValues);
        Event_User retrievedEventUsers = (Event_User)genericDao.getById(eventUsers.get(0).getId());
        int eventId = retrievedEventUsers.getEvents_id();
        logger.info("retrievedEventUsers.getEvents_id()  " + eventId);

        genericDao.delete(genericDao.getById(eventId));

//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/displayProfile.jsp");
//        dispatcher.forward(req, resp);
        resp.sendRedirect("http://localhost:8080/DOFORFUND_war/displayProfiles");
    }
}


