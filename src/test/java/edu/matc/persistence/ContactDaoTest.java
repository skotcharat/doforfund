package edu.matc.persistence;

import edu.matc.entity.Contact;
import edu.matc.entity.Event_User;
import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.test.util.DatabaseUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User role dao test.
 */
class ContactDaoTest {
    /**
     * genericDao
     */
    //UserRoleDao dao;
    GenericDao genericDao;
    GenericDao genericDaoUser;
    DatabaseUtility databaseUtility;

    /**
     * Creating the dao successfully.
     */
    @BeforeEach
    void setUp() {
        //dao = new UserRoleDao();
        genericDao = new GenericDao(Contact.class);
        genericDaoUser = new GenericDao(User.class);

        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleandb.sql");
        databaseUtility.runSQL("createTestData.sql");
    }

    /**
     * Verifies Gets all contact successfully.
     */
    @Test
    void getAll() {
        List<Contact> contacts = genericDao.getAll();
        assertEquals(3, contacts.size());
    }

    /**
     * Verifies Gets by id successfully.
     */
    @Test
    void getById() {
        Contact retrievedContact = (Contact)genericDao.getById(2);
        assertNotNull(retrievedContact);
        assertEquals("message2", retrievedContact.getMessage());
    }



    /**
     * Verifies Delete successfully.
     */
    @Test
    void delete() {
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }

    /**
     * Verifies Save or update successfully.
     */
    @Test
    void saveOrUpdate() {
        String newUserContact = "meme";
        Contact toUpdate = (Contact)genericDao.getById(2);
        toUpdate.setFirstname(newUserContact);
        genericDao.saveOrUpdate(toUpdate);
        Contact retrievednewContact = (Contact)genericDao.getById(2);
        assertEquals(newUserContact, retrievednewContact.getFirstname());
        String expected = "meme";
        String actual = retrievednewContact.getFirstname();
        assertTrue(expected.equals(actual));
    }

    /**
     * Verifies Gets by property equal successfully.
     */
    @Test
    void getByPropertyEqual() {
        List<Contact> contact = genericDao.getByPropertyEqual("subject", "hi3");
        assertEquals(1, contact.size());
        assertEquals(3, contact.get(0).getId());
    }


    /**
     * Verifies Gets by property like successfully.
     */
    @Test
    void getByPropertyLike() {
        List<Contact> contact = genericDao.getByPropertyLike("subject", "i");
        assertEquals(3, contact.size());
    }

}