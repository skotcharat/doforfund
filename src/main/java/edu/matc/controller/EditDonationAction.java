package edu.matc.controller;

import edu.matc.entity.Contact;
import edu.matc.entity.Donation;
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
        urlPatterns = {"/editDonationAction"}
)
public class EditDonationAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Donation> genericDao = DaoFactory.createDao(Donation.class);
        Donation contactBeforeUpdate = genericDao.getById(Integer.parseInt(req.getParameter("ParameterId")));
        contactBeforeUpdate.setAmount(Integer.parseInt(req.getParameter("amount")));
//        contactBeforeUpdate.setSub(req.getParameter("subject"));
//        contactBeforeUpdate.set(req.getParameter("message"));

        genericDao.saveOrUpdate(contactBeforeUpdate);

        resp.sendRedirect("http://localhost:8080/DOFORFUND_war/adminPage");
    }
}





