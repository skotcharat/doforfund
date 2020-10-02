package edu.matc.persistence;

import edu.matc.entity.User;
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
     * genericDao
     */
    //UserRoleDao dao;
    GenericDao genericDao;

    /**
     * Creating the dao successfully.
     */
    @BeforeEach
    void setUp() {
        //dao = new UserRoleDao();
        genericDao = new GenericDao(UserRole.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
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
        UserRole retrievedOrderUserRole = (UserRole)genericDao.getById(4);
        assertNotNull(retrievedOrderUserRole);
        assertEquals("answer_question", retrievedOrderUserRole.getRoleName());
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
        String newUserRole = "edit_profile";
        UserRole userRoleToUpdate = (UserRole)genericDao.getById(3);
        userRoleToUpdate.setRoleName(newUserRole);
        genericDao.saveOrUpdate(userRoleToUpdate);
        UserRole retrievednewUserRole = (UserRole)genericDao.getById(3);
        assertEquals(newUserRole, retrievednewUserRole.getRoleName());
    }

    /**
     * Verifies Insert successfully.
     */
    @Test
    void insert() {
        //UserDao userDao = new UserDao();
        User user = (User)genericDao.getById(2);
        String roleName = "sign_in";
        UserRole newUserRoles = new UserRole(roleName, user);
        user.addUserRoles(newUserRoles);
        int id = genericDao.insert(newUserRoles);
        assertNotEquals(0, id);
        UserRole insertedUser = (UserRole)genericDao.getById(id);
        assertNotNull(insertedUser);
        assertEquals(roleName, insertedUser.getRoleName());
        assertNotNull(insertedUser.getUser());
        assertEquals("Fred", insertedUser.getUser().getFirstName());
    }


    /**
     * Verifies Gets by property equal successfully.
     * "roleName" from instance UserRole class
     */
    @Test
    void getByPropertyEqual() {
        List<UserRole> userRoles = genericDao.getByPropertyEqual("roleName", "donation");
        assertEquals(1, userRoles.size());
        assertEquals(2, userRoles.get(0).getId());
    }

    /**
     * Verifies Gets by property like successfully.
     */
    @Test
    void getByPropertyLike() {
        List<UserRole> userRoles = genericDao.getByPropertyLike("roleName", "n");
        assertEquals(4, userRoles.size());
    }
}