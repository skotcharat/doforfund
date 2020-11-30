package edu.matc.controller;

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
        urlPatterns = {"/editProfileAction"}
)

public class EditProfileAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<User> genericDao = DaoFactory.createDao(User.class);
        User userBeforeUpdate = genericDao.getById(Integer.parseInt(req.getParameter("ParameterId")));
        userBeforeUpdate.setFirstName(req.getParameter("fname"));
        userBeforeUpdate.setLastName(req.getParameter("lname"));
        userBeforeUpdate.setUserName(req.getParameter("username"));
        userBeforeUpdate.setPassword(req.getParameter("password"));
        userBeforeUpdate.setEmail(req.getParameter("email"));
        genericDao.saveOrUpdate(userBeforeUpdate);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/displayProfiles");
        dispatcher.forward(req, resp);
    }
}

