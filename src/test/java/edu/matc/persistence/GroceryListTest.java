package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRecipes;
import edu.matc.entity.GroceryList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import java.util.List;

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
}
