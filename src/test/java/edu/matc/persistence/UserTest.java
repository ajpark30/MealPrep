package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRecipes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    User user;
    GenericDao genericDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        logger.info("----------Cleaning Database with sql script for User Testing----------");
        genericDao = new GenericDao(User.class);
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        logger.info("^^^^^^^^^^Starting test to delete a user.");
        genericDao.delete(genericDao.getById(4));
        assertNull(genericDao.getById(4));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        logger.info("^^^^^^^^^^Starting test to get all users.");
        List<User> users = genericDao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getUserByLastName() {

        logger.info("^^^^^^^^^^Starting test to get a user by last name.");
        List<User> retrievedUser = genericDao.getByLastName("Hulk");
        assertEquals("Hulk", retrievedUser.get(0).getLastName());

        List<User> retrievedUser2 = genericDao.getByLastName("ma");
        assertEquals(2, retrievedUser2.size());
        assertEquals("Man", retrievedUser2.get(0).getLastName());
        assertEquals("Marvel", retrievedUser2.get(1).getLastName());
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getUserByIdSuccess() {

        logger.info("^^^^^^^^^^Starting test to get a user by ID.");
        User retrievedUser = (User)genericDao.getById(3);
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

        logger.info("^^^^^^^^^^Starting test to insert a user.");
        User newUser = new User("Thor", "Odinson", "Tester7", "test");
        genericDao.insert(newUser);
        int userId = newUser.getUserId();
        User insertedUser = (User)genericDao.getById(userId);
        assertEquals("Thor", insertedUser.getFirstName());
    }

    /**
     * Verify successful insert of a user recipe
     */
    @Test
    void insertUserRecipesSuccess() {

        logger.info("^^^^^^^^^^Starting test to check if a user recipe set is added to a user object.");
        User newUser = new User("Ham", "Burgler", "CHzPlz", "test");

        String userRecipeTitle = "Cheese Burger";
        LocalDateTime recipeOriginDate = LocalDateTime.now();
        logger.info("-------Locale date time: " + recipeOriginDate.toString() + "----------");

        UserRecipes newUserRecipes = new UserRecipes(newUser, userRecipeTitle, recipeOriginDate);
        newUser.addUserRecipes(newUserRecipes);

        genericDao.insert(newUser);
        int userId = newUser.getUserId();

        User insertedUser = (User)genericDao.getById(userId);
        assertEquals("Ham", insertedUser.getFirstName());
    }

    /**
     * Verify successful save or update of a user
     * I'm concerned about the auto_increment being set here... Will it get too big?
     */
    @Test
    void saveOrUpdate() {
        logger.info("^^^^^^^^^^Starting Test That Saves a new User");
        User saveUser = new User("Thor1", "Odinson1", "HammerTime33", "test1");
        genericDao.saveOrUpdate(saveUser);
        int saveUserId = saveUser.getUserId();
        User insertedUser = (User) genericDao.getById(saveUserId);
        assertEquals("Thor1", insertedUser.getFirstName());
        assertEquals("Odinson1", insertedUser.getLastName());
        assertEquals("HammerTime33", insertedUser.getUserName());
        assertEquals("test1", insertedUser.getUserPassword());

        User updateUser = (User)genericDao.getById(6);
        updateUser.setUserName("CaptMarv33");
        logger.info("^^^^^^^^^^Starting Test That Updates an existing User");
        genericDao.saveOrUpdate(updateUser);
        int updateUserId = updateUser.getUserId();
        User updatedUser = (User)genericDao.getById(updateUserId);
        assertEquals("Captain", updatedUser.getFirstName());
        assertEquals("Marvel", updatedUser.getLastName());
        assertEquals("CaptMarv33", updatedUser.getUserName());
        assertEquals("Test6", updatedUser.getUserPassword());

    }

}