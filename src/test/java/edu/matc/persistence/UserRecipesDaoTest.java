package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRecipes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserRecipesDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    UserRecipesDao userRecipesDao;
    UserDao userDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        logger.info("----------Cleaning Database with sql script----------");
        userRecipesDao = new UserRecipesDao();
    }

    /**
     * Verify successful request of all recipes from the database.
     */
    @Test
    void getAllUserRecipes() {
        List<UserRecipes> userRecipesList = userRecipesDao.getAllUserRecipes();
        assertEquals(10, userRecipesList.size());
    }

    /**
     * Verify successful request for recipe/recipes by last name.
     */
    @Test
    void getUserRecipesByLastName() {
        logger.info("^^^^^^^^^^Starting test to get user recipes by last name.");
        List<UserRecipes> userRecipes = userRecipesDao.getUserRecipesByLastName("Hulk");
        logger.info("^^^^^^^^^^Test found last name: " + userRecipes);
        assertEquals(2, userRecipes.size());
        assertEquals("Tacos", userRecipes.get(0).getRecipeTitle());
        assertEquals("Shrimp Larb", userRecipes.get(1).getRecipeTitle());

    }

    /**
     * Verify successful request for a recipe by its ID.
     */
    @Test
    void getUserRecipesById() {
        List<UserRecipes> userRecipes = userRecipesDao.getUserRecipesById(1);
        int count = 0;
        for (int i = 0; i < userRecipes.size(); i++ ){
            count++;
        }

        assertEquals(2, count);
        assertEquals("Tacos", userRecipes.get(0).getRecipeTitle());
        assertEquals("2019-03-03 19:53:00.0", userRecipes.get(0).getDateTimeCreated().toString());
        assertEquals("Shrimp Larb", userRecipes.get(1).getRecipeTitle());
        assertEquals("2019-03-03 19:53:00.0", userRecipes.get(1).getDateTimeCreated().toString());

        //Look for a way to test the current time without hard coding it.
    }

    /**
     * Verify successful save|update to a recipe.
     */
    @Test
    void saveOrUpdate() {
    }

    /**
     * Verify successful insertion of a recipe.
     */
    @Test
    void insertUserRecipes() {
    }

    /**
     * Verify successful deletion of a recipe.
     */
    @Test
    void delete() {
    }
}