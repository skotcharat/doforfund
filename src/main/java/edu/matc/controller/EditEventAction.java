package edu.matc.controller;

import edu.matc.entity.Contact;
import edu.matc.entity.Event;
import edu.matc.persistence.GenericDao;
import edu.matc.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/editEventAction"}
)

public class EditEventAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Event> genericDao = DaoFactory.createDao(Event.class);
        Event eventBeforeUpdate = genericDao.getById(Integer.parseInt(req.getParameter("ParameterId")));
        eventBeforeUpdate.setEventName(req.getParameter("eventName"));
        eventBeforeUpdate.setEventPlace(req.getParameter("eventPlace"));
        eventBeforeUpdate.setEventDate(req.getParameter("eventDate"));
        eventBeforeUpdate.setEventTime(req.getParameter("eventTime"));
        eventBeforeUpdate.setEventDescription(req.getParameter("eventDescription"));
        genericDao.saveOrUpdate(eventBeforeUpdate);

        resp.sendRedirect("http://localhost:8080/DOFORFUND_war/adminPage");
    }
}

