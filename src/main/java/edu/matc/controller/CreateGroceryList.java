package edu.matc.controller;

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
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<User> userGenericDao= new GenericDao<>(User.class);
        GenericDao<UserRecipes> userRecipesGenericDao = new GenericDao<>(UserRecipes.class);
        GenericDao<Ingredients> ingredientsGenericDao = new GenericDao<>(Ingredients.class);

        if (req.getParameter("submit").equals("submit")) {

        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/createGroceryListConfirmation.jsp");
        dispatcher.forward(req, resp);
    }
}
