package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
     * Verify successful retrieval of a User
     */
    @Test
    void getById() {
        User retrievedUser = dao.getById(1);
        assertEquals("Joe", retrievedUser.getFirstName());

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
     * Verify successful retrieval of all User
     */
    @Test
    void getAll() {
        List<User> users = dao.getAll();
        assertEquals(2, users.size());
    }
}