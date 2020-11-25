package edu.matc.persistence;

import edu.matc.entity.Event;
import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.test.util.DatabaseUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;


class EventDaoTest {

    GenericDao genericDao;
    DatabaseUtility databaseUtility;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(Event.class);

        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleandb.sql");
        databaseUtility.runSQL("createTestData.sql");

    }

    /**
     * Verify successful retrieval of all Event
     */
    @Test
    void getAll() {
        List<Event> events = genericDao.getAll();
        assertEquals(3, events.size());
    }

    /**
     * Verify successful retrieval of a Event
     */
    @Test
    void getById() {
        Event retrievedUser = (Event)genericDao.getById(2);
        assertNotNull(retrievedUser);
        assertEquals("Couple shot", retrievedUser.getEventName());
    }

    /**
     * Verify successful insert of a Event
     */
    @Test
    void insert() {
        Event newEvent = new Event("blackandwhite", "matc", "2020-11-19", "11:30:00", "Let join us");
        int id = genericDao.insert(newEvent);
        assertNotEquals(0,id);
        Event insertedEvent = (Event)genericDao.getById(id);
        String expectedEvent = "blackandwhite";
        String actualEvent = insertedEvent.getEventName();
        assertTrue(expectedEvent.equals(actualEvent));

    }

    /**
     * Verify successful delete of Event
     */
    @Test
    void delete() {
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }

    /**
     * Verify successful update of a Event
     */
    @Test
    void saveOrUpdate() {
        String updateNewEvent = "2020-11-30";
        Event eventBeforeUpdate = (Event)genericDao.getById(3);
        eventBeforeUpdate.setEventDate(updateNewEvent);
        genericDao.saveOrUpdate(eventBeforeUpdate);
        Event eventAfterUpdate = (Event)genericDao.getById(3);
        String expectedEvent = "2020-11-30";
        String actualEvent = eventAfterUpdate.getEventDate();
        assertTrue(expectedEvent.equals(actualEvent));
    }

//    /**
//     * Verify successful insert of a user and an userRole
//     */
//    @Test
//    void insertWithRoleSuccess() {
//
//        String userRoleName = "sign_out";
//        User newUser = new User("Fred", "Flintstone", "fflintstone", "Flin@mail.com");
//        UserRole userRoles = new UserRole(userRoleName, newUser);
//        newUser.addUserRoles(userRoles);
//        int id = genericDao.insert(newUser);
//        assertNotEquals(0, id);
//        User insertedUser = (User)genericDao.getById(id);
//        assertNotNull(insertedUser);
//        assertEquals("Fred", insertedUser.getFirstName());
//        assertEquals(1, insertedUser.getUserRoles().size());
//
//        // Could continue comparing all values, but
//        // it may make sense to use .equals()
//        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
//    }

    /**
     * Verify successful get by property (equal match)
     * propertyName is name match in the Event table
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Event> users = genericDao.getByPropertyEqual("eventPlace", "matc");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = genericDao.getByPropertyLike("eventName", "fun");
        assertEquals(1, users.size());
    }








}