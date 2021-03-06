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
import java.util.Properties;

@WebServlet(
        urlPatterns = {"/cancelEventWithId"}
)

public class CancleEventWithId extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties;

    // constructor
    public CancleEventWithId() {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Event_User> genericDao = DaoFactory.createDao(Event_User.class);
        GenericDao<User> genericDaoUser = DaoFactory.createDao(User.class);

        // get user that login
        List<User> users = genericDaoUser.getByPropertyEqual("userName", req.getRemoteUser());
        int id = users.get(0).getId();

        // compare value with multiple column
        Map<String, Object> propsAndValues = new HashMap<>();
        propsAndValues.put("user_id", id);
        propsAndValues.put("events_id", req.getParameter("CancelWithId"));

        // retrive id from the result events_user table
        List<Event_User> eventUsers = genericDao.findByPropertyEqual(propsAndValues);
        Event_User retrievedEventUsers = (Event_User)genericDao.getById(eventUsers.get(0).getId());
        logger.info("retrievedEventUsers  " + retrievedEventUsers);
        int eventUserId = retrievedEventUsers.getId();
        logger.info("retrievedEventUsers.getEvents_id()  " + eventUserId);

        // delete id from the result events_user table
        genericDao.delete(genericDao.getById(eventUserId));

        resp.sendRedirect(properties.getProperty("url") + "/displayProfiles");
    }
}


