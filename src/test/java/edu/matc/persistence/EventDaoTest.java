package edu.matc.persistence;

import edu.matc.entity.Event;
import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.test.util.DatabaseUtility;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


class EventDaoTest {
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
        assertEquals(4, events.size());
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

//    /**
//     * Verify successful insert of a Event
//     */
//    @SneakyThrows
//    @Test
//    void insert() {
//        LocalDate chosenDate = LocalDate.parse("2020-11-11");
//        LocalTime time = LocalTime.parse("11:30:00");
//
//        logger.info("chosenDate  " + chosenDate);
//        Event newEvent = new Event("blackandwhite", "matc", chosenDate, time, "Let join us");
//        int id = genericDao.insert(newEvent);
//        assertNotEquals(0,id);
//        Event insertedEvent = (Event)genericDao.getById(id);
//        String expectedEvent = "blackandwhite";
//        String actualEvent = insertedEvent.getEventName();
//        assertTrue(expectedEvent.equals(actualEvent));
//    }

    /**
     * Verify successful delete of Event
     */
    @Test
    void delete() {
        genericDao.delete(genericDao.getById(4));
        assertNull(genericDao.getById(4));
    }

//    /**
//     * Verify successful update of a Event
//     */
//    @Test
//    void saveOrUpdate() {
//        String updateNewEvent = "Capital";
//        Event eventBeforeUpdate = (Event)genericDao.getById(3);
//        eventBeforeUpdate.setEventPlace(updateNewEvent);
//        genericDao.saveOrUpdate(eventBeforeUpdate);
//        Event eventAfterUpdate = (Event)genericDao.getById(3);
//        String expectedEvent = "Capital";
//        String actualEvent = eventAfterUpdate.getEventPlace();
//        assertTrue(expectedEvent.equals(actualEvent));
//    }


    /**
     * Verify successful get by property (equal match)
     * propertyName is name match in the Event table
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Event> events = genericDao.getByPropertyEqual("eventPlace", "matc");
        assertEquals(1, events.size());
        assertEquals(1, events.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Event> events = genericDao.getByPropertyLike("eventName", "fun");
        assertEquals(2, events.size());
    }

}