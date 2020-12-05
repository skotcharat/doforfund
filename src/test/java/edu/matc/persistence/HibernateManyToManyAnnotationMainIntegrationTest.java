//package edu.matc.persistence;
//import edu.matc.entity.Event;
//import edu.matc.entity.User;
//import edu.matc.test.util.DatabaseUtility;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import javax.persistence.EntityManager;
//import java.util.HashSet;
//import java.util.Set;
//import static org.junit.Assert.*;
//
//public class HibernateManyToManyAnnotationMainIntegrationTest {
//
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    GenericDao genericDaoEvent;
//    GenericDao genericDaoUser;
//    DatabaseUtility databaseUtility;
//    private EntityManager session;
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
//    }
//
//    // ...
//
//    @Test
//    public void givenData_whenInsert_thenCreatesMtoMrelationship() {
//        int userData = 3;
//        int eventData = 3;
////        Set<Event> eventMany = new HashSet<>();
////
////        //for (int event : eventData) {
////            eventMany.add(new Event(eventData));
////        //}
////
////        //for (int user : userData) {
////            User user1 = new User(userData);
////
////            assertEquals(0, user1.getEventMany().size());
////            user1.setEventMany(eventMany);
////            session.persist(user1);
////
////            assertNotNull(user1);
////        //}
//
//        User newUser = new User(userData);
//        Event newEvent = new Event(eventData);
//        newUser.addEvent(newEvent);
//        int id = genericDaoUser.insert(newUser);
//        User insertedUser = (User)genericDaoUser.getById(id);
//
//    }
//}
