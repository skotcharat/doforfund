package edu.matc.persistence;


import edu.matc.entity.Event_User;
import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.test.util.DatabaseUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

@Transactional

class EventUserDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Session session;
    Transaction transaction = null;

    //UserDao dao;
    GenericDao genericDao;
    GenericDao genericDaoEvent;
    DatabaseUtility databaseUtility;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        //dao = new UserDao();
        genericDao = new GenericDao(Event_User.class);

        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleandb.sql");
        databaseUtility.runSQL("createTestData.sql");

    }

    /**
     * Verify successful retrieval of all eventUsers
     */
    @Test
    void getAll() {
        List<Event_User> eventUsers = genericDao.getAll();
        assertEquals(3, eventUsers.size());
    }

    /**
     * Verify successful retrieval of a eventUsers
     */
    @Test
    void getById() {
        Event_User retrievedEventUsers = (Event_User)genericDao.getById(2);
        assertNotNull(retrievedEventUsers);
        assertEquals(2, retrievedEventUsers.getEvents_id());
    }

    /**
     * Verify successful insert of a eventUsers
     */
    @Test
    void insert() {
        Event_User newEventUser = new Event_User(4, 2);
        int id = genericDao.insert(newEventUser);
        assertNotEquals(0,id);
        Event_User insertedEventUser = (Event_User)genericDao.getById(id);
        int expected = 2;
        int actual = insertedEventUser.getUser_id();
        assertEquals(expected, actual);

    }

    /**
     * Verify successful delete of eventUsers
     */
    @Test
    void delete() {
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }


    /**
     * Verify successful get by property (equal match)
     * propertyName is name match in the User table
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Event_User> users = genericDao.getByPropertyEqual("user_id", "2");
        assertEquals(2, users.size());
    }
}