package edu.matc.persistence;

import edu.matc.entity.Ingredients;
import edu.matc.entity.User;
import edu.matc.entity.UserRecipes;
import edu.matc.entity.GroceryList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GroceryListTest {

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
        logger.info("----------Cleaning Database with sql script for Grocery List Testing----------");
        genericDao = new GenericDao(GroceryList.class);
    }

    /**
     * Verify successful request of all recipes from the database.
     */
    @Test
    void getAllUserGroceryLists() {
        logger.info("^^^^^^^^^^Starting test to get all grocery lists.");
        List<GroceryList> groceryLists = genericDao.getAll();
        assertEquals(9, groceryLists.size());
    }

    @Test
    void getGrocerylistByItsName() {
        Integer integer = 1;
        logger.info("^^^^^^^^^Starting test to get all grocery lists by grocery list name.");
        GenericDao groceryListDao = new GenericDao(GroceryList.class);
        List<GroceryList> groceryLists = groceryListDao.getGrocerylistByItsName("Week 1");
        logger.info("^^^^^^^^^^Test found grocery lists using grocery list name: " + groceryLists);

//        Set<Ingredients> ingredientsSet= new HashSet<>();
//        for (int i = 0; i < groceryLists.size(); i++) {
//            ingredientsSet.add(groceryLists.ge);
//        }
        assertEquals(5, groceryLists.size());
        assertEquals("Week 1", groceryLists.get(0).getGrocerylistName());
        assertEquals(integer, groceryLists.get(4).getIngredientId());
    }

}
