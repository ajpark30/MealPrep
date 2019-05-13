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
        name = "CreateGroceryList",
        urlPatterns = {"/createGroceryList"}
)

public class CreateGroceryList extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<User> userGenericDao= new GenericDao<>(User.class);
        GenericDao<UserRecipes> userRecipesGenericDao = new GenericDao<>(UserRecipes.class);
        GenericDao<Ingredients> ingredientsGenericDao = new GenericDao<>(Ingredients.class);
        GenericDao<GroceryList> groceryListGenericDao = new GenericDao<>(GroceryList.class);

        if (req.getParameter("submit").equals("submit")) {

            //Get the logged in user name
            String remoteUser = req.getRemoteUser();
            logger.info("**********Grabbing User Name to add a new Grocery list: " + remoteUser);

            //Get the user_id based of the logged in user name
            List<User> user = userGenericDao.getByUserName(remoteUser);
            Integer userId = user.get(0).getUserId();

            //Adding Ingredients to new grocery list
            String firstInputIngredient = req.getParameter("firstIngredient");
            String secondInputIngredient = req.getParameter("secondIngredient");
            String thirdInputIngredient = req.getParameter("thirdIngredient");

            //Create sets for grocery list object.
            Set<UserRecipes> userRecipesSet = new HashSet<UserRecipes>();
            Set<Ingredients> ingredientsSet = new HashSet<Ingredients>();
            Set<User> usersSet = new HashSet<User>();

            ingredientsSet.add(ingredientsGenericDao.getByExactName(firstInputIngredient));
            ingredientsSet.add(ingredientsGenericDao.getByExactName(secondInputIngredient));
            ingredientsSet.add(ingredientsGenericDao.getByExactName(thirdInputIngredient));

            logger.info("**********Adding ingredients " + firstInputIngredient + ", " + secondInputIngredient + ", "
                        + thirdInputIngredient + " to the new/updated grocery list: " + req.getParameter("groceryListName"));

            //Grab a user and add a new grocery list to the database under their user id
            GroceryList groceryList = new GroceryList(req.getParameter("groceryListName"), userId, ingredientsSet, userRecipesSet, usersSet);
            logger.info("**********Saving/Updating a Grocerylist: " + groceryList + "----- For User: " + user);
            groceryListGenericDao.saveOrUpdate(groceryList);

            logger.info("**********Grocery list with added Ingredient: " + groceryList);

            req.setAttribute("userName", user.get(0).getFirstName());
            req.setAttribute("groceryListName", groceryList.getGrocerylistName());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/createGroceryListConfirmation.jsp");
        dispatcher.forward(req, resp);
    }
}
