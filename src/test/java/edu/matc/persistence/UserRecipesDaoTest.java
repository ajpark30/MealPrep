package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRecipes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserRecipesDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
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
        logger.info("----------Cleaning Database with sql script for User Recipe Testing----------");
        genericDao = new GenericDao(UserRecipes.class);
    }

    /**
     * Verify successful request of all recipes from the database.
     */
    @Test
    void getAllUserRecipes() {
        logger.info("^^^^^^^^^^Starting test to get all user recipes.");
        List<UserRecipes> userRecipesList = genericDao.getAll();
        assertEquals(10, userRecipesList.size());
    }

    /**
     * Verify successful request for recipe/recipes by last name.
     */
    @Test
    void getUserRecipesByLastName() {
        logger.info("^^^^^^^^^^Starting test to get user recipes by last name.");
        GenericDao userDao = new GenericDao(User.class);
        List <User> user = userDao.getByLastName("Hulk");
        List<UserRecipes> userRecipes = genericDao.getRecipesByUserId(user.get(0).getUserId());
        logger.info("^^^^^^^^^^Test found recipes by user last name: " + userRecipes);
        assertEquals(1, user.size());
        assertEquals("Tacos", userRecipes.get(0).getRecipeTitle());
        assertEquals("Shrimp Larb", userRecipes.get(1).getRecipeTitle());

    }

    /**
     * Verify successful request for a recipe by its ID.
     * TODO Look for a way to test the current time without hard coding it.
     */
    @Test
    void getRecipesByUserId() {
        List<UserRecipes> userRecipes = genericDao.getRecipesByUserId(1);
        int count = 0;
        for (int i = 0; i < userRecipes.size(); i++ ){
            count++;
        }

        assertEquals(2, count);
        assertEquals("Tacos", userRecipes.get(0).getRecipeTitle());
        assertEquals("2019-03-03T13:53", userRecipes.get(0).getDateTimeCreated().toString());
        assertEquals("Shrimp Larb", userRecipes.get(1).getRecipeTitle());
        assertEquals("2019-03-03T13:53", userRecipes.get(1).getDateTimeCreated().toString());

    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getRecipeByRecipeId() {

        logger.info("^^^^^^^^^^Starting test to get a user by ID.");
        UserRecipes retrievedUser = (UserRecipes)genericDao.getById(3);
        assertEquals("Peter", retrievedUser.getUser().getFirstName());
        assertEquals("Nachos", retrievedUser.getRecipeTitle());
    }

    /**
     * Verify successful save|update to a recipe.
     */
    @Test
    void saveOrUpdate() {

        logger.info("^^^^^^^^^^Starting save or update Test");

        //Grab a user and add a new recipe to the database under their user id
        LocalDateTime localDateTime = LocalDateTime.now();
        GenericDao userDao = new GenericDao(User.class);
        userDao.getById(4);
        logger.info("^^^^^^^^^^Grabbed user ID to save using save/update method: " + userDao.getById(4));
        UserRecipes saveUserRecipes = new UserRecipes((User)userDao.getById(4), "Rib Eye Steak", localDateTime);
        logger.info("^^^^^^^^^^Created user to save using save/update method: " + saveUserRecipes);
        genericDao.saveOrUpdate(saveUserRecipes);
        logger.info("^^^^^^^^^^New recipe saved successfully!");

        //Create a list of all the recipes that user id 4 has in the database.
        List<UserRecipes> userRecipes = genericDao.getRecipesByUserId(4);
        int count = 0;
        for (int i = 0; i < userRecipes.size(); i++ ){
            count++;
        }

        //Grab a user and update one of they recipes they have in the database.
        logger.info("^^^^^^^^^^Starting recipe update process");
        List<UserRecipes> updateUserRecipe = genericDao.getRecipesByUserId(6);
        updateUserRecipe.get(0).setRecipeTitle("Macaroni and Cheese");
        genericDao.saveOrUpdate(updateUserRecipe.get(0));

        //Check to see if a new recipe was added to a user.
        assertEquals("Rib Eye Steak", saveUserRecipes.getRecipeTitle());
        assertEquals(1, count);

        //Check to see if an existing recipe was updated.
        assertEquals("Macaroni and Cheese", updateUserRecipe.get(0).getRecipeTitle());
    }

    /**
     * Verify successful insertion of a recipe.
     */
    @Test
    void insertUserRecipes() {

        //Insert a new recipe into the userRecipe table.
        logger.info("^^^^^^^^^^Starting insert recipe process");
        LocalDateTime localDateTime = LocalDateTime.now();
        GenericDao userDao = new GenericDao(User.class);
        userDao.getById(5);
        logger.info("^^^^^^^^^^Grabbed user ID to insert a new recipe: " + userDao.getById(5));
        UserRecipes insertUserRecipes = new UserRecipes((User)userDao.getById(5), "Pepperoni Pizza", localDateTime);
        genericDao.insert(insertUserRecipes);
        logger.info("^^^^^^^^^^Inserted a new recipe: " + insertUserRecipes);

        assertEquals("Pepperoni Pizza", insertUserRecipes.getRecipeTitle());

    }

    /**
     * Verify successful deletion of a recipe.
     */
    @Test
    void delete() {

        //deleting one recipe for a user.
        logger.info("^^^^^^^^^^Starting delete recipe process");
        logger.info("^^^^^^^^^^Grabbed recipe ID to delete a recipe: " + genericDao.getById(3));
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }
}