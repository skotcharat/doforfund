package edu.matc.persistence;


import edu.matc.entity.Event;
import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.test.util.Database;
import edu.matc.test.util.DatabaseUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
@Transactional

class UserDaoTest {

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
        genericDao = new GenericDao(User.class);

        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleandb.sql");
        databaseUtility.runSQL("createTestData.sql");

    }

    /**
     * Verify successful retrieval of all User
     */
    @Test
    void getAll() {
        List<User> users = genericDao.getAll();
        assertEquals(4, users.size());
    }

    /**
     * Verify successful retrieval of a User
     */
    @Test
    void getById() {
        User retrievedUser = (User)genericDao.getById(2);
        assertNotNull(retrievedUser);
        assertEquals("Fred", retrievedUser.getFirstName());
    }

    /**
     * Verify successful insert of a User
     */
    @Test
    void insert() {
        User newUser = new User("steven", "kot", "ypp", "yk@mail.com");
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        String expectedUser = "steven";
        String actualUser = insertedUser.getFirstName();
        assertTrue(expectedUser.equals(actualUser));

    }

    /**
     * Verify successful delete of User
     */
    @Test
    void delete() {
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }

    /**
     * Verify successful update of a User
     */
    @Test
    void saveOrUpdate() {
        String updateNewUser = "John";
        User userBeforeUpdate = (User)genericDao.getById(2);
        userBeforeUpdate.setFirstName(updateNewUser);
        genericDao.saveOrUpdate(userBeforeUpdate);
        User userAfterUpdate = (User)genericDao.getById(2);
        String expectedUser = "John";
        String actualUser = userAfterUpdate.getFirstName();
        assertTrue(expectedUser.equals(actualUser));
    }

    /**
     * Verify successful insert of a user and an userRole
     */
    @Test
    void insertWithRoleSuccess() {
        String userRoleName = "user";
        User newUser = new User("Fred", "Flintstone", "fflintstone", "Flin@mail.com");
        UserRole userRoles = new UserRole(userRoleName, "fflintstone", newUser);
        newUser.addUserRoles(userRoles);
        int id = genericDao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = (User)genericDao.getById(id);
        assertNotNull(insertedUser);
        assertEquals("Fred", insertedUser.getFirstName());
        assertEquals(1, insertedUser.getUserRoles().size());
    }


    /**
     * Verify successful get by property (equal match)
     * propertyName is name match in the User table
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = genericDao.getByPropertyEqual("lastName", "Coyne");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());

        // For loop
        for(User userRole : users) {
            logger.info(userRole.userRoles);
        }
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = genericDao.getByPropertyLike("lastName", "c");
        assertEquals(1, users.size());
    }




}