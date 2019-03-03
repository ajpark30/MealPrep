package edu.matc.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRecipesDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
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

    @Test
    void getAllUserRecipes() {
    }

    @Test
    void getUserRecipesById() {
    }

    @Test
    void getUserRecipesByLastName() {
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void insertUserRecipes() {
    }

    @Test
    void delete() {
    }
}