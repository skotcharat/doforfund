package edu.matc.controller;


import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import edu.matc.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class FindUser extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //String param1 = req.getParameter("param1");
        final Logger logger = LogManager.getLogger(this.getClass());


        GenericDao<User> dao = DaoFactory.createDao(User.class);
        List<User> allUsers = dao.getAll();

        req.setAttribute("allUsers", allUsers);
        logger.debug("Sending back the user/s..." + allUsers);



        //req.setAttribute("allUsers", dao.getByPropertyEqual("lastName", "Coyne"));
        //req.setAttribute("allUsers", dao.getById(2));


        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
