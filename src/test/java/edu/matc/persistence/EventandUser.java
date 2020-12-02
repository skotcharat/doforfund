package edu.matc.persistence;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import edu.matc.entity.Donation;
import edu.matc.entity.Event;
import edu.matc.entity.User;
import edu.matc.test.util.DatabaseUtility;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EventandUser {

//    private final Logger logger = (Logger) LogManager.getLogger(this.getClass());
//    GenericDao genericDaoEvent;
//    GenericDao genericDaoUser;
//    DatabaseUtility databaseUtility;
//
//    /**
//     * Run set up tasks before each test:
//     * 1. execute sql which deletes everything from the table and inserts records
//     * 2. Create any objects needed in the tests
//     */
//    @BeforeEach
//    void setUp() {
//
//        genericDaoEvent = new GenericDao(Event.class);
//        genericDaoUser = new GenericDao(User.class);
//
//        databaseUtility = new DatabaseUtility();
//        databaseUtility.runSQL("cleandb.sql");
//        databaseUtility.runSQL("createTestData.sql");
//
//    }
    private static SessionFactory sessionFactory;
    private Session session;
@Test
    public void givenData_whenInsert_thenCreatesMtoMrelationship() {
        String[] userData = { "Peter Oven", "Allan Norman" };
        String[] eventData = { "IT Project", "Networking Project" };
        Set<Event> events = new HashSet<>();

        for (String eventHere : eventData) {
            events.add(new Event(eventHere));
        }

        for (String userHere : userData) {
            User users = new User(userHere.split(" ")[0],
                    userHere.split(" ")[1]);


            assertEquals(0, users.getEventsJoin().size());
            users.setEventsJoin(events);
            //session.persist(users);

            assertNotNull(users);
        }
    }


}
