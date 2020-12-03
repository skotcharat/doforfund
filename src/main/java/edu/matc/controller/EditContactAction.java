package edu.matc.controller;

import edu.matc.entity.Contact;
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
        urlPatterns = {"/editContactAction"}
)

public class EditContactAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Contact> genericDao = DaoFactory.createDao(Contact.class);
        Contact contactBeforeUpdate = genericDao.getById(Integer.parseInt(req.getParameter("ParameterId")));
        contactBeforeUpdate.setFirstname(req.getParameter("fname"));
        contactBeforeUpdate.setLastname(req.getParameter("lname"));
        contactBeforeUpdate.setEmail(req.getParameter("email"));
        contactBeforeUpdate.setSubject(req.getParameter("subject"));
        contactBeforeUpdate.setMessage(req.getParameter("message"));
        genericDao.saveOrUpdate(contactBeforeUpdate);

        resp.sendRedirect("http://localhost:8080/DOFORFUND_war/adminPage");
    }
}

