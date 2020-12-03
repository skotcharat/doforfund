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

@WebServlet(
        urlPatterns = {"/editEventAction"}
)

public class EditEventAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @SneakyThrows
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

        resp.sendRedirect("http://localhost:8080/DOFORFUND_war/adminPage");
    }
}

