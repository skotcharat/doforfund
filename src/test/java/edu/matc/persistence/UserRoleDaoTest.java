package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.test.util.Database;
import edu.matc.test.util.DatabaseUtility;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User role dao test.
 */
class UserRoleDaoTest {
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
        genericDao = new GenericDao(UserRole.class);
        genericDaoUser = new GenericDao(User.class);

        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleandb.sql");
        databaseUtility.runSQL("createTestData.sql");
    }

    /**
     * Verifies Gets all user roles successfully.
     */
    @Test
    void getAllUserRoles() {
        List<UserRole> userRoles = genericDao.getAll();
        assertEquals(4, userRoles.size());
    }

    /**
     * Verifies Gets by id successfully.
     */
    @Test
    void getById() {
        UserRole retrievedOrderUserRole = (UserRole)genericDao.getById(1);
        assertNotNull(retrievedOrderUserRole);
        assertEquals("admin", retrievedOrderUserRole.getRoleName());
    }

    /**
     * Verifies Insert successfully.
     */
    @Test
    void insert() {
        User user = (User)genericDaoUser.getById(1);
        String roleName = "sign_in";
        String UserName = "mayay";

        UserRole newUserRoles = new UserRole(roleName, "mayay", user);
        user.addUserRoles(newUserRoles);
        int id = genericDao.insert(newUserRoles);
        assertNotEquals(0, id);
        UserRole insertedUser = (UserRole)genericDao.getById(id);
        assertNotNull(insertedUser);
        assertEquals(roleName, insertedUser.getRoleName());
        assertNotNull(insertedUser.getUser());
        assertEquals("Joe", insertedUser.getUser().getFirstName());
        String expectedUser = "Joe";
        String actualUser = insertedUser.getUser().getFirstName();
        assertTrue(expectedUser.equals(actualUser));

    }

    /**
     * Verifies Delete successfully.
     */
    @Test
    void delete() {
        genericDao.delete(genericDao.getById(2));
        assertNull(genericDao.getById(2));
    }

    /**
     * Verifies Save or update successfully.
     */
    @Test
    void saveOrUpdate() {
        String newUserRole = "user";
        UserRole userRoleToUpdate = (UserRole)genericDao.getById(2);
        userRoleToUpdate.setRoleName(newUserRole);
        genericDao.saveOrUpdate(userRoleToUpdate);
        UserRole retrievednewUserRole = (UserRole)genericDao.getById(2);
        assertEquals(newUserRole, retrievednewUserRole.getRoleName());
        String expectedUserRole = "user";
        String actualUserRole = retrievednewUserRole.getRoleName();
        assertTrue(expectedUserRole.equals(actualUserRole));
    }

    /**
     * Verifies Gets by property equal successfully.
     * "roleName" from instance UserRole class
     */
    @Test
    void getByPropertyEqual() {
        List<UserRole> role = genericDao.getByPropertyEqual("roleName", "user");
        assertEquals(1, role.size());
        assertEquals(2, role.get(0).getId());
    }

    /**
     * Verifies Gets by property like successfully.
     */
    @Test
    void getByPropertyLike() {
        List<UserRole> userRoles = genericDao.getByPropertyLike("roleName", "n");
        assertEquals(3, userRoles.size());
    }
}