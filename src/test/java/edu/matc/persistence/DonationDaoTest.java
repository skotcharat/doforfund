package edu.matc.persistence;

import edu.matc.entity.Donation;
import edu.matc.entity.Event;
import edu.matc.entity.User;
import edu.matc.test.util.DatabaseUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DonationDaoTest {
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





}
