package edu.matc.controller;



import edu.matc.entity.Donation;
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

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet
        (urlPatterns = { "/sumDonate" } )



public class SumDonate extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Donation> genericDao = DaoFactory.createDao(Donation.class);
        int amount = Integer.parseInt(req.getParameter("amount"));

        Donation donation = new Donation(amount);

        int newId = genericDao.insert(donation);
        // get the donation current amount
        Donation donation2 = genericDao.getById(newId);
        req.setAttribute("donateAmount", donation2);
        logger.debug("Sending back the donateAmount/s..." + donation2);

        // get the donation total amount
        int total = 0;
        for(int i = 0; i < genericDao.getAll().size(); i++) {
            //total += (Integer)genericDao.getById(i);
        }
        req.setAttribute("totalAmount", genericDao.getAll().size());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/sumDonation.jsp");
        dispatcher.forward(req, resp);
    }

}
