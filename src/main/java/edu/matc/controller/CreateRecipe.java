package edu.matc.controller;

import edu.matc.entity.GroceryList;
import edu.matc.entity.Ingredients;
import edu.matc.entity.User;
import edu.matc.entity.UserRecipes;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Bean to request form data to add a new user to the database
 * @author Andrew Park
 */

@WebServlet(
        name = "CreateRecipe",
        urlPatterns = {"/createRecipe"}
)

public class CreateRecipe extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<User> userGenericDao= new GenericDao<>(User.class);
        GenericDao<UserRecipes> userRecipesGenericDao = new GenericDao<>(UserRecipes.class);
        GenericDao<Ingredients> ingredientsGenericDao = new GenericDao<>(Ingredients.class);

        if (req.getParameter("submit").equals("submit")) {

            //Get the logged in user name
            String remoteUser = req.getRemoteUser();
            logger.info("********** Grabbing User Name to create Grocery List: " + remoteUser);

            String recipeTitle = req.getParameter("recipeName");
            String firstIngredient = req.getParameter("firstIngredient");
            String secondIngredient = req.getParameter("secondIngredient");
            String thirdIngredient = req.getParameter("thirdIngredient");

            Ingredients ingredientOne = new Ingredients();
            Ingredients ingredientTwo = new Ingredients();
            Ingredients ingredientThree = new Ingredients();

            Set<Ingredients> ingredientsSet = new HashSet<>();
            ingredientsSet.add(ingredientOne);
            ingredientsSet.add(ingredientTwo);
            ingredientsSet.add(ingredientThree);


            User user = new User();
            List<User> userList = userGenericDao.getByUserName(remoteUser);

            user.setUserId(userList.get(0).getUserId());
            user.setUserName(userList.get(0).getUserName());

            UserRecipes userRecipes = new UserRecipes();
            userRecipes.setRecipeTitle(recipeTitle);
            userRecipes.setUser(user);
            userRecipes.setIngredients(ingredientsSet);

        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/createRecipeConfirmation.jsp");
        dispatcher.forward(req, resp);
    }
}
