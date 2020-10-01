package edu.matc.persistence;

import edu.matc.entity.UserRole;
import edu.matc.test.util.Database;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User role dao test.
 */
class UserRoleDaoTest {
    /**
     * The Dao.
     */
    UserRoleDao dao;

    /**
     * Creating the dao successfully.
     */
    @BeforeEach
    void setUp() {
        dao = new UserRoleDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies Gets all user roles successfully.
     */
    @Test
    void getAllUserRoles() {
        List<UserRole> userRoles = dao.getAllUserRoles();
        assertEquals(4, userRoles.size());
    }

    /**
     * Verifies Gets by id successfully.
     */
    @Test
    void getById() {
        UserRole retrievedOrderUserRole = dao.getById(4);
        assertNotNull(retrievedOrderUserRole);
        assertEquals("answer_question", retrievedOrderUserRole.getRoleName());
    }

    /**
     * Verifies Delete successfully.
     */
    @Test
    void delete() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    /**
     * Verifies Save or update successfully.
     */
    @Test
    void saveOrUpdate() {

    }

    /**
     * Verifies Insert successfully.
     */
    @Test
    void insert() {
    }



    /**
     * Verifies Gets by property equal successfully.
     */
    @Test
    void getByPropertyEqual() {
    }

    /**
     * Verifies Gets by property like successfully.
     */
    @Test
    void getByPropertyLike() {
    }
}