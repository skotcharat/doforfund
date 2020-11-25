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
        urlPatterns = {"/editProfileWithId"}
)

public class EditProfileWithId extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //User updateUser = new User(req.getParameter("fname"), req.getParameter("lname"),
               // req.getParameter("username"), req.getParameter("password"), req.getParameter("email"));


        //genericDao.saveOrUpdate(updateUser);

        GenericDao<User> genericDao = DaoFactory.createDao(User.class);
        User userBeforeUpdate = genericDao.getById(Integer.parseInt(req.getParameter("EditWithId")));
        req.setAttribute("userEdit", userBeforeUpdate);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editProfile.jsp");
        dispatcher.forward(req, resp);
    }

}


