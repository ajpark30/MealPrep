package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRecipes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserRecipesDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    UserRecipesDao userRecipesDao;
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

        logger.info("^^^^^^^^^^Starting saveOrUpate Test");

        //Grab a user and add a new recipe to the database under their user id
        Date date = new Date();
        UserDao user = new UserDao();
        user.getUserById(4);
        logger.info("^^^^^^^^^^Grabbed user ID to save using save/update method: " + user.getUserById(4));
        UserRecipes saveUserRecipes = new UserRecipes(user.getUserById(4), "Rib Eye Steak", date);
        logger.info("^^^^^^^^^^Created user to save using save/update method: " + saveUserRecipes);
        userRecipesDao.saveOrUpdate(saveUserRecipes);
        logger.info("^^^^^^^^^^New recipe saved successfully!");

        //Create a list of all the recipes that user id 4 has in the database.
        List<UserRecipes> userRecipes = userRecipesDao.getUserRecipesById(4);
        int count = 0;
        for (int i = 0; i < userRecipes.size(); i++ ){
            count++;
        }

        //Grab a user and update one of they recipes they have in the database.
        logger.info("^^^^^^^^^^Starting recipe update process");
        List<UserRecipes> updateUserRecipe = userRecipesDao.getUserRecipesById(6);
        updateUserRecipe.get(0).setRecipeTitle("Macaroni and Cheese");
        userRecipesDao.saveOrUpdate(updateUserRecipe.get(0));

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
        Date date = new Date();
        UserDao user = new UserDao();
        user.getUserById(5);
        logger.info("^^^^^^^^^^Grabbed user ID to insert a new recipe: " + user.getUserById(5));
        UserRecipes insertUserRecipes = new UserRecipes(user.getUserById(5), "Pepperoni Pizza", date);
        userRecipesDao.insertUserRecipes(insertUserRecipes);
        logger.info("^^^^^^^^^^Inserted a new recipe: " + insertUserRecipes);

        assertEquals("Pepperoni Pizza", insertUserRecipes.getRecipeTitle());

    }

    /**
     * Verify successful deletion of a recipe.
     */
//    @Test
//    void delete() {
//
//        //deleting one recipe for a user.
//        UserDao user = new UserDao();
//        user.getUserById(2);
//        logger.info("^^^^^^^^^^Grabbed user ID to delete a recipe: " + user.getUserById(2));
//        UserRecipes deleteUserRecipes = new UserRecipes(user.getUserById(5), "Pepperoni Pizza", date);
//
//
//    }
}