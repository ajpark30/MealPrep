package edu.matc.controller;

import edu.matc.entity.Ingredients;
import edu.matc.entity.User;
import edu.matc.entity.UserRecipes;
import edu.matc.entity.YummlyDataGrabber;
import edu.matc.persistence.GenericDao;
import edu.matc.yummly.recipes.Criteria;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(
        name = "SearchRecipes",
        urlPatterns = {"/searchRecipes"}
)

public class SearchRecipes extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao genericRecipeDao = new GenericDao(UserRecipes.class);
        GenericDao genericUserDao = new GenericDao(User.class);
        YummlyDataGrabber yummlyDataGrabber = new YummlyDataGrabber();
        Criteria criteria = new Criteria();

        //Request the submit button value and get the entered value, send that to the dao as a search term
        if (req.getParameter("submit").equals("searchUserRecipes")) {
            String lastname = req.getParameter("searchTerm");
            List<User> user = genericUserDao.getByLastName(lastname);
            List<UserRecipes> userRecipes = genericRecipeDao.getRecipesByUserId(user.get(0).getUserId());
            logger.info("Recipe Info found: " + userRecipes);

            Set<Ingredients> ingredientsSet = userRecipes.get(0).getIngredients();
            List<String> ingredientsList = new ArrayList<>();

            for (Ingredients ingredients : ingredientsSet) {
                ingredientsList.add(ingredients.getIngredientName());
            }

            logger.info("$$$$$$$$$ Working on finding the ingredients: " + ingredientsList);

            req.setAttribute("recipeInfo", userRecipes);
            req.setAttribute("ingredientsList", ingredientsList);
        }

        try {
            if (req.getParameter("submit").equals("newRecipeSearch")) {

                String recipeName = URLEncoder.encode(req.getParameter("newRecipeSearch"), "UTF-8");
                logger.info("$$$$$$$$$$ New Recipe Search term recieved: " + recipeName);
                criteria = yummlyDataGrabber.getCriteria(recipeName);

                List<String> newRecipesFound = new ArrayList<>();

                for (int i = 0; i < 10; i++) {
                    newRecipesFound.add(criteria.getMatches().get(i).getRecipeName());
                }
                logger.info("$$$$$$$$$$ New Recipe Search found: " + newRecipesFound);
                req.setAttribute("newRecipeInfo", newRecipesFound);
            }
        } catch (Exception e){
            logger.error("Ran into Exception error when searching for new recipe: " + e);
        }

        if (req.getParameter("submit").equals("viewAll")) {

            List<UserRecipes> userRecipesList = genericRecipeDao.getAll();
            Set<Ingredients> ingredientsSet = userRecipesList.get(0).getIngredients();

            List<String> ingredientsList = new ArrayList<>();

            for (Ingredients ingredients : ingredientsSet) {
                ingredientsList.add(ingredients.getIngredientName());
            }

            logger.info("$$$$$$$$$ Working on finding the ingredients: " + ingredientsList);

            req.setAttribute("recipeInfo", userRecipesList);
            req.setAttribute("ingredientsList", ingredientsList);
        }

        if (req.getParameter("submit").equals("viewById")) {
            Integer id = Integer.parseInt(req.getParameter("searchTerm"));
            req.setAttribute("recipeInfo", genericRecipeDao.getRecipesByUserId(id));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/searchForRecipeResults.jsp");
        dispatcher.forward(req, resp);

    }
}
