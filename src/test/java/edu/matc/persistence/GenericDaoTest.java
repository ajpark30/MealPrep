package edu.matc.persistence;

import edu.matc.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.id.IncrementGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.net.www.content.text.Generic;


import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GenericDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<User> genericUserDao = new GenericDao(User.class);
    GenericDao<UserRecipes> genericUserRecipeDao = new GenericDao(UserRecipes.class);
    GenericDao<Ingredients> genericIngredientDao = new GenericDao(Ingredients.class);
    GenericDao<GroceryList> genericGroceryListDao = new GenericDao(GroceryList.class);
    GenericDao<WeeklyMealPlan> genericWeeklyMealPlanDao = new GenericDao(WeeklyMealPlan.class);

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
    }

/** Users **/

    /**
     * Verify successful delete of user by User ID
     */
    @Test
    void deleteUserByUserId() {
        logger.info("^^^^^^^^^^Starting test to delete a user by User ID");
        //find a user by ID
        User userTest = genericUserDao.getById(4);

        //find any grocery list they have and delete each one
        List<GroceryList> groceryListTest = genericGroceryListDao.getGrocerylistsByUserId(4);

        //Deleting Users grocerylists
        for (int i = 0; i < groceryListTest.size(); i++) {
            genericGroceryListDao.delete(groceryListTest.get(i));
        }

        genericUserDao.delete(userTest);
        assertNull(genericUserDao.getById(4));
    }

    /**
     * Verify successful insert of a user
     * I'm concerned about the auto_increment being set here... Will it get too big?
     * TODO Do I need this?  Look into it
     */
    @Test
    void insertUser() {

        logger.info("^^^^^^^^^^Starting test to insert a user.");
        User newUser = new User("Thor", "Odinson", "Tester7", "test");
        genericUserDao.insert(newUser);
        Integer userId = newUser.getUserId();
        User insertedUser = (User)genericUserDao.getById(userId);
        assertEquals("Thor", insertedUser.getFirstName());
    }

    /**
     * Verify successful save or update of a user
     * I'm concerned about the auto_increment being set here... Will it get too big?
     */
    @Test
    void saveOrUpdateUser() {

        //Testing save or Update that saves new user
        logger.info("^^^^^^^^^^Starting Test That Saves a new User");
        User saveUser = new User("Black", "Widow", "WidowMaker", "test33");
        genericUserDao.saveOrUpdate(saveUser);
        Integer saveUserId = saveUser.getUserId();
        User insertedUser = (User) genericUserDao.getById(saveUserId);
        assertEquals("Black", insertedUser.getFirstName());
        assertEquals("Widow", insertedUser.getLastName());
        assertEquals("WidowMaker", insertedUser.getUserName());
        assertEquals("test33", insertedUser.getUserPassword());

        User updateUser = (User)genericUserDao.getById(6);
        updateUser.setUserName("CaptMarv33");
        logger.info("^^^^^^^^^^Starting Test That Updates an existing User");
        genericUserDao.saveOrUpdate(updateUser);
        Integer updateUserId = updateUser.getUserId();
        User updatedUser = (User)genericUserDao.getById(updateUserId);
        assertEquals("Captain", updatedUser.getFirstName());
        assertEquals("Marvel", updatedUser.getLastName());
        assertEquals("CaptMarv33", updatedUser.getUserName());
        assertEquals("Test6", updatedUser.getUserPassword());
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllUsers() {
        logger.info("^^^^^^^^^^Starting test to get all users.");
        List<User> users = genericUserDao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Verify successful retrieval of a user user last name
     */
    @Test
    void getUserByLastName() {

        logger.info("^^^^^^^^^^Starting test to get a user by last name.");
        List<User> retrievedUser = genericUserDao.getByLastName("Hulk");
        assertEquals("Hulk", retrievedUser.get(0).getLastName());

        List<User> retrievedUser2 = genericUserDao.getByLastName("ma");
        assertEquals(2, retrievedUser2.size());
        assertEquals("Man", retrievedUser2.get(0).getLastName());
        assertEquals("Marvel", retrievedUser2.get(1).getLastName());
    }

    /**
     * Verify successful retrieval of a user by ID
     */
    @Test
    void getUserByUserId() {

        logger.info("^^^^^^^^^^Starting test to get a user by User ID.");
        User retrievedUser = (User)genericUserDao.getById(3);
        assertEquals("Captain", retrievedUser.getFirstName());
        assertEquals("America", retrievedUser.getLastName());
        assertEquals("Tester3", retrievedUser.getUserName());

    }


/** User Recipes **/

    /**
     * Verify successful deletion of a recipe bu user id.
     */
    @Test
    void deleteUserRecipesByUserId() {

        String emptyValue = "[]";
        List<UserRecipes> userRecipesTest = genericUserRecipeDao.getRecipesByUserId(3);
        //deleting one recipe for a user.
        logger.info("^^^^^^^^^^Starting delete recipe by user ID process");
        logger.info("^^^^^^^^^^Grabbed User Recipe by User ID to delete all recipes: " + userRecipesTest);

        //Iteration to delete all recipes with the found user ID
        for (int i = 0; i < userRecipesTest.size(); i++) {
            genericUserRecipeDao.delete(userRecipesTest.get(i));
        }

        //Assert we have emptied the object and its size is 0
        assertEquals(0, genericUserRecipeDao.getRecipesByUserId(3).size());
    }

    /**
     * Verify successful insertion of a recipe.
     * TODO Do I need this?  Look into it
     */
    @Test
    void insertUserRecipes() {

        //Insert a new recipe into the userRecipe table.
        logger.info("^^^^^^^^^^Starting insert recipe process");
        LocalDateTime localDateTime = LocalDateTime.now();
        GenericDao userDao = new GenericDao(User.class);
        userDao.getById(5);
        Set<GroceryList> groceryListSet = new HashSet<GroceryList>(0);
        Set<Ingredients> ingredientsSet = new HashSet<Ingredients>(0);

        logger.info("^^^^^^^^^^Grabbed user ID to insert a new recipe: " + userDao.getById(5));
        UserRecipes insertUserRecipes = new UserRecipes((User)userDao.getById(5), "Pepperoni Pizza", localDateTime, groceryListSet, ingredientsSet);
        //genericDao.insert(insertUserRecipes);
        logger.info("^^^^^^^^^^Inserted a new recipe: " + insertUserRecipes);

        assertEquals("Pepperoni Pizza", insertUserRecipes.getRecipeTitle());

    }

    /**
     * Verify successful save or update of a user recipe
     */
    @Test
    void saveOrUpdateRecipe() {

        logger.info("^^^^^^^^^^Starting Save or Update Recipe Test");

        LocalDateTime localDateTime = LocalDateTime.now();

        Set<GroceryList> groceryListSet = new HashSet<GroceryList>(0);
        Set<Ingredients> ingredientsSet = new HashSet<Ingredients>(0);

        //Grab a user and add a new recipe to the database under their user id
        UserRecipes saveUserRecipes = new UserRecipes(genericUserDao.getById(5), "Rib Eye Steak", localDateTime, groceryListSet, ingredientsSet);
        logger.info("^^^^^^^^^^Created user to save using save/update method: " + saveUserRecipes);
        genericUserRecipeDao.saveOrUpdate(saveUserRecipes);

        //Grab a user and update one of they recipes they have in the database.
        logger.info("^^^^^^^^^^Starting recipe update process");
        List<UserRecipes> updateUserRecipe = genericUserRecipeDao.getRecipesByUserId(6);
        updateUserRecipe.get(0).setRecipeTitle("Macaroni and Cheese");
        genericUserRecipeDao.saveOrUpdate(updateUserRecipe.get(0));

        //Check to see if a new recipe was added to a user.
        assertEquals("Rib Eye Steak", saveUserRecipes.getRecipeTitle());
        assertEquals(3, genericUserRecipeDao.getRecipesByUserId(5).size());

        //Check to see if an existing recipe was updated.
        assertEquals("Macaroni and Cheese", updateUserRecipe.get(0).getRecipeTitle());
    }

    /**
     * Verify successful request of all recipes from the database.
     */
    @Test
    void getAllUserRecipes() {
        logger.info("^^^^^^^^^^Starting test to get all user recipes.");
        List<UserRecipes> userRecipesList = genericUserRecipeDao.getAll();
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
        List<UserRecipes> userRecipes = genericUserRecipeDao.getRecipesByUserId(user.get(0).getUserId());
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
    void getUserRecipesByUserId() {
        logger.info("^^^^^^^^^^Starting Recipe request by recipe ID");
        List<UserRecipes> userRecipes = genericUserRecipeDao.getRecipesByUserId(1);
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
     * Verify successful retrieval of a recipe by recipe ID
     */
    @Test
    void getUserRecipeByRecipeId() {

        UserRecipes retrievedRecipe = genericUserRecipeDao.getById(10);
        logger.info("^^^^^^^^^^Starting test to get a recipe by ID found: " + retrievedRecipe);
        assertEquals("Captain", retrievedRecipe.getUser().getFirstName());
        assertEquals("Marvel",retrievedRecipe.getUser().getLastName());
        assertEquals("Bibimbap", retrievedRecipe.getRecipeTitle());
    }


/** Grocery List **/

    /**
     * Verify successful request of all Grocery Lists from the database.
     */
    @Test
    void getAllUserGroceryLists() {
        logger.info("^^^^^^^^^^Starting test to get all grocery lists.");
        List<GroceryList> groceryLists = genericGroceryListDao.getAll();
        assertEquals(9, groceryLists.size());
    }

    /**
     * Verify user can delete a grocery list
     */
    @Test
    void deleteGroceryListById() {
        logger.info("^^^^^^^^^^Starting test to delete a grocery list by grocery list ID");
        //find a grocery list by ID
        GroceryList groceryList = genericGroceryListDao.getById(1);

        logger.info("^^^^^^^^^^Found grocery list: " + groceryList);

        genericGroceryListDao.delete(groceryList);
        assertNull(genericGroceryListDao.getById(1));
    }

    /**
     * verify a user can save or update a grocerylist
     */
    @Test
    void saveGroceryList() {
        logger.info("^^^^^^^^^^Starting Save or Update Grocery List Test");

        User user = genericUserDao.getById(5);

        Ingredients ingredients = genericIngredientDao.getByExactName("Carrots");
        Ingredients ingredients1 = genericIngredientDao.getByExactName("Kale");
        Ingredients ingredients2 = genericIngredientDao.getByExactName("Onion");
        Set<UserRecipes> userRecipesSet = new HashSet<UserRecipes>();
        Set<Ingredients> ingredientsSet = new HashSet<Ingredients>();
        ingredientsSet.add(ingredients);
        ingredientsSet.add(ingredients1);
        ingredientsSet.add(ingredients2);

        Set<User> usersSet = new HashSet<User>(0);

        //Grab a user and add a new grocery list to the database under their user id
        GroceryList groceryListTest = new GroceryList("Add Tester", user.getUserId(), ingredientsSet, userRecipesSet, usersSet);
        logger.info("^^^^^^^^^^Created Grocerylist to save using save/update method: " + groceryListTest);
        genericGroceryListDao.saveOrUpdate(groceryListTest);

        //Check to see if a new recipe was added to a user.
        assertEquals("Add Tester", genericGroceryListDao.getGrocerylistsByUserId(5).get(0).getGrocerylistName());
        assertEquals(1, genericGroceryListDao.getGrocerylistsByUserId(5).size());

        //Check to see if the grocery list has the added ingredients.
        assertEquals(3, genericGroceryListDao.getGrocerylistsByUserId(5).get(0).getIngredients().size());
    }

    /**
     * Update Grocery list that already exists
     */
     @Test
     void updateGroceryList() {

         logger.info("^^^^^^^^^^Starting Update Grocery List Test");
         //Grab a user and update one of they recipes they have in the database.
         logger.info("^^^^^^^^^^Starting Grocery List update process");
         GroceryList updateGroceryList = genericGroceryListDao.getById(3);
         updateGroceryList.setGrocerylistName("Favorite Week");
         genericGroceryListDao.saveOrUpdate(updateGroceryList);

         //Check to see if an existing recipe was updated.
         assertEquals("Favorite Week", genericGroceryListDao.getGrocerylistsByUserId(1).get(1).getGrocerylistName());
     }

    /**
     * Get a grocery list by the name of the grocery list
     */
    @Test
    void getGrocerylistByGroceryListName() {

        Integer integer = 1;
        logger.info("^^^^^^^^^Starting test to get all grocery lists by grocery list name.");
        GenericDao groceryListDao = new GenericDao(GroceryList.class);
        List<GroceryList> groceryLists = groceryListDao.getGrocerylistByItsName("Week 1");
        logger.info("^^^^^^^^^^Test found grocery lists using grocery list name: " + groceryLists);

        assertEquals(2, groceryLists.size());
        assertEquals("Week 1", groceryLists.get(0).getGrocerylistName());
        //assertEquals(integer, groceryLists.get(4).getIngredientId());
    }

    /**
     * Add ingredient to grocery list
     */
//    @Test
//    void addIngredientsToGroceryList() {
//        logger.info("Starting test to add ingredients to grocery list");
//    }

/** Ingredients **/

    /**
     * Verify successful saving or updating of an ingredient
     */
    @Test
    void saveOrUpdateIngredient() {
        logger.info("^^^^^^^^^^Starting Save or Update Ingredient Test");

        double price = 1.20;
        Ingredients testIngredient = new Ingredients("Cabbage", "Leafy Green Vegetable", price, "Per Pound", "Local");

        genericIngredientDao.saveOrUpdate(testIngredient);

        assertEquals(7, genericIngredientDao.getAll().size());
        assertEquals("Cabbage", genericIngredientDao.getByExactName("cabbage").getIngredientName());
        assertEquals("Cabbage", genericIngredientDao.getByApproximateName("ingredientName","abba").getIngredientName());

        //Grab an ingredient and update it.
        logger.info("^^^^^^^^^^Starting ingredient update process");
        Ingredients updateIngredient = genericIngredientDao.getById(6);
        updateIngredient.setIngredientName("Carrot");
        updateIngredient.setBrand("Local Farmer");

        genericIngredientDao.saveOrUpdate(updateIngredient);

        assertEquals(7, genericIngredientDao.getAll().size());
        assertEquals("Carrot", genericIngredientDao.getByExactName("Carrot").getIngredientName());

    }


/** Weekly Meal Plans **/

    /**
     * Verify a user can save or update a weekly meal plan
     */
    @Test
    void saveOrUpdateWeeklyMealPlan() {

    }

}