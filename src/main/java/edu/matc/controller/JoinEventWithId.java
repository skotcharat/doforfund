package edu.matc.controller;

import edu.matc.entity.Contact;
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
        urlPatterns = {"/editContactWithId"}
)

public class JoinEventWithId extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Contact> genericDao = DaoFactory.createDao(Contact.class);
        Contact userBeforeUpdate = genericDao.getById(Integer.parseInt(req.getParameter("EditWithId")));
        req.setAttribute("contactEdit", userBeforeUpdate);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editContact.jsp");
        dispatcher.forward(req, resp);
    }


}


