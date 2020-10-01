package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.persistence.UserDao;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;


class UserDaoTest {
    UserDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDao();
    }

    /**
     * Verify successful retrieval of all User
     */
    @Test
    void getAll() {
        List<User> users = dao.getAll();
        assertEquals(2, users.size());
    }

    /**
     * Verify successful retrieval of a User
     */
    @Test
    void getById() {
        User retrievedUser = dao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Joe", retrievedUser.getFirstName());
    }

    /**
     * Verify successful insert of a User
     */
    @Test
    void insert() {
        User newUser = new User("ying", "kot", "yk", "yk@mail.com");
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("ying", insertedUser.getFirstName());
    }

    /**
     * Verify successful delete of User
     */
    @Test
    void delete() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Verify successful update of a User
     */
    @Test
    void saveOrUpdate() {
        String updateNewUser = "John";
        User userBeforeUpdate = dao.getById(2);
        userBeforeUpdate.setFirstName(updateNewUser);
        dao.saveOrUpdate(userBeforeUpdate);
        User userAfterUpdate = dao.getById(2);
        assertEquals(updateNewUser, userAfterUpdate.getFirstName());
    }

    /**
     * Verify successful insert of a user and an userRole
     */
    @Test
    void insertWithOrderSuccess() {

        String userRoleName = "sign_out";
        User newUser = new User("Fred", "Flintstone", "fflintstone", "Flin@mail.com");
        UserRole userRoles = new UserRole(userRoleName, newUser);
        newUser.addUserRoles(userRoles);
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertNotNull(insertedUser);
        assertEquals("Fred", insertedUser.getFirstName());
        assertEquals(1, insertedUser.getUserRoles().size());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "Hensen");
        assertEquals(1, users.size());
        assertEquals(2, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "c");
        assertEquals(1, users.size());
    }







}