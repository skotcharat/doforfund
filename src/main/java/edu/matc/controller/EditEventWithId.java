package edu.matc.controller;

import edu.matc.entity.Event;
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

@WebServlet(
        urlPatterns = {"/editEventWithId"}
)

public class EditEventWithId extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Event> genericDao = DaoFactory.createDao(Event.class);
        User userBeforeUpdate = genericDao.getById(Integer.parseInt(req.getParameter("EditWithId")));
        req.setAttribute("eventEdit", userBeforeUpdate);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editEvent.jsp");
        dispatcher.forward(req, resp);
    }


}


