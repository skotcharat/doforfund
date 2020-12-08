package edu.matc.persistence;

import edu.matc.entity.Donation;
import edu.matc.entity.Event;
import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.test.util.DatabaseUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class DonationDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao genericDao;
    DatabaseUtility databaseUtility;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(Donation.class);

        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleandb.sql");
        databaseUtility.runSQL("createTestData.sql");

    }

    /**
     * Verify successful retrieval of all Donation
     */
    @Test
    void getAll() {
        List<Donation> donations = genericDao.getAll();
        assertEquals(3, donations.size());
    }

    /**
     * Verify successful retrieval of a Donation
     */
    @Test
    void getById() {
        Donation retrievedDonation = (Donation)genericDao.getById(2);
        assertNotNull(retrievedDonation);
        assertEquals(20, retrievedDonation.getAmount());
    }

    /**
     * Verify successful insert of a Donation
     */
    @Test
    void insert() {
        Donation newDonation = new Donation(40, LocalDate.now(), "hi");
        int id = genericDao.insert(newDonation);
        assertNotEquals(0,id);
        Donation insertedDonation = (Donation)genericDao.getById(id);
        String expectedDonation = "hi";
        String actualDonation = insertedDonation.getSubject();
        assertTrue(expectedDonation.equals(actualDonation));

    }

    /**
     * Verify successful delete of Donation
     */
    @Test
    void delete() {
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }

    /**
     * Verify successful update of a Donation
     */
    @Test
    void saveOrUpdate() {
        String updateNewDonation = "Today fun";
        Donation donationBeforeUpdate = (Donation)genericDao.getById(2);
        donationBeforeUpdate.setSubject(updateNewDonation);
        genericDao.saveOrUpdate(donationBeforeUpdate);
        Donation donationAfterUpdate = (Donation)genericDao.getById(2);
        String expectedDonation = "Today fun";
        String actualDonation = donationAfterUpdate.getSubject();
        assertTrue(expectedDonation.equals(actualDonation));
    }

    /**
     * Verify successful get by property (equal match)
     * propertyName is name in Entity set match in the table
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Donation> donation = genericDao.getByPropertyEqual("amount", "20");
        assertEquals(1, donation.size());
        assertEquals(2, donation.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = genericDao.getByPropertyLike("subject", "f");
        assertEquals(3, users.size());
    }
}






