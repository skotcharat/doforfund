package edu.matc.controller;

import edu.matc.entity.Contact;
import edu.matc.entity.Event;
import edu.matc.persistence.GenericDao;
import edu.matc.util.DaoFactory;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Properties;

@WebServlet(
        urlPatterns = {"/editEventAction"}
)

public class EditEventAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties;

    // constructor
    public EditEventAction() {
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

        GenericDao<Event> genericDao = DaoFactory.createDao(Event.class);
        Event eventBeforeUpdate = genericDao.getById(Integer.parseInt(req.getParameter("ParameterId")));
        eventBeforeUpdate.setEventName(req.getParameter("eventName"));
        eventBeforeUpdate.setEventPlace(req.getParameter("eventPlace"));

        LocalDate chosenDate = LocalDate.parse(req.getParameter("eventDate"));
        eventBeforeUpdate.setEventDate(chosenDate);

        LocalTime time = LocalTime.parse(req.getParameter("eventTime"));
        eventBeforeUpdate.setEventTime(time);

        eventBeforeUpdate.setEventDescription(req.getParameter("eventDescription"));
        genericDao.saveOrUpdate(eventBeforeUpdate);

        resp.sendRedirect(properties.getProperty("url") + "/adminPage");
    }
}

