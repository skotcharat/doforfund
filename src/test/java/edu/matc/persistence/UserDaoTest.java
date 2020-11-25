package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.test.util.Database;
import edu.matc.test.util.DatabaseUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;


class UserDaoTest {
    //UserDao dao;
    GenericDao genericDao;
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
        assertEquals(2, users.size());
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

        String userRoleName = "sign_out";
        User newUser = new User("Fred", "Flintstone", "fflintstone", "Flin@mail.com");
        UserRole userRoles = new UserRole(userRoleName, newUser);
        newUser.addUserRoles(userRoles);
        int id = genericDao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = (User)genericDao.getById(id);
        assertNotNull(insertedUser);
        assertEquals("Fred", insertedUser.getFirstName());
        assertEquals(1, insertedUser.getUserRoles().size());

        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful get by property (equal match)
     * propertyName is name match in the User table
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = genericDao.getByPropertyEqual("lastName", "Hensen");
        assertEquals(1, users.size());
        assertEquals(2, users.get(0).getId());
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