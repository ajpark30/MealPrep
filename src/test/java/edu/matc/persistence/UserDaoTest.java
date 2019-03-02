package edu.matc.persistence;

import edu.matc.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDao();
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getUserById(4));
        assertNull(dao.getUserById(4));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAllUsers();
        assertEquals(5, users.size());
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getUserByLastName() {
        List<User> retrievedUser = dao.getUserByLastName("hulk");
        assertEquals("Hulk", retrievedUser.get(0).getLastName());

        List<User> retrievedUser2 = dao.getUserByLastName("ma");
        assertEquals(2, retrievedUser2.size());
        assertEquals("Man", retrievedUser2.get(0).getLastName());
        assertEquals("Marvel", retrievedUser2.get(1).getLastName());
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getUserById(3);
        assertEquals("Captain", retrievedUser.getFirstName());
        assertEquals("America", retrievedUser.getLastName());
        assertEquals("Tester3", retrievedUser.getUserName());

    }

    /**
     * Verify successful insert of a user
     * I'm concerned about the auto_increment being set here... Will it get too big?
     */
    @Test
    void insertSuccess() {

        User newUser = new User("Thor", "Odinson", "Tester7", "test");
        dao.insertUser(newUser);
        int userId = newUser.getUserId();
        User insertedUser = dao.getUserById(userId);
        assertEquals("Thor", insertedUser.getFirstName());
    }

}