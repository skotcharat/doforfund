package edu.matc.controller;



import edu.matc.entity.Donation;
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
import java.time.LocalDate;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet
        (urlPatterns = { "/sumDonate" } )


public class SumDonate extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<User> genericDaoUser = DaoFactory.createDao(User.class);
        GenericDao<Donation> genericDao = DaoFactory.createDao(Donation.class);

        if(req.isUserInRole("user")) {
            // retrive user id from current user
            String username = req.getRemoteUser();
            List<User> users = genericDaoUser.getByPropertyEqual("userName", username);
            int id = users.get(0).getId();
            logger.info("ContactInfo class ID  " + id);
            User retrievedUser = (User)genericDaoUser.getById(id);

            // get parameter from input
            int amount = Integer.parseInt(req.getParameter("amount"));
            String subject = req.getParameter("subject");

            // insert donation information to the table
            Donation donation = new Donation(amount, LocalDate.now(), subject, username, retrievedUser);
            int newId = genericDao.insert(donation);

            // get the donation current amount
            Donation donation2 = genericDao.getById(newId);
            req.setAttribute("donateAmount", donation2);
            logger.debug("Sending back the donateAmount/s..." + donation2);

            // get all the donations to calculate the amount
            List<Donation> allDonation = genericDao.getAll();
            req.setAttribute("totalAmount", allDonation);
            logger.debug("Sending back the donateAmount/s..." + allDonation);

        } else {
            int amount = Integer.parseInt(req.getParameter("amount"));
            String subject = req.getParameter("subject");
            Donation donation = new Donation(amount, LocalDate.now(), subject);
            int newId = genericDao.insert(donation);

            // get the donation current amount
            Donation donation2 = genericDao.getById(newId);
            req.setAttribute("donateAmount", donation2);
            logger.debug("Sending back the donateAmount/s..." + donation2);

            // get all the donations to calculate the amount
            List<Donation> allDonation = genericDao.getAll();
            req.setAttribute("totalAmount", allDonation);
            logger.debug("Sending back the donateAmount/s..." + allDonation);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/sumDonation.jsp");
        dispatcher.forward(req, resp);
    }

}
