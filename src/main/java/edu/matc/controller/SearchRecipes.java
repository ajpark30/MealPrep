package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.entity.UserRecipes;
import edu.matc.persistence.GenericDao;
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
import java.util.List;

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
        if (req.getParameter("submit").equals("search")) {
            String lastname = req.getParameter("searchTerm");
            List<User> user = genericUserDao.getByLastName(lastname);
            List<UserRecipes> userRecipes = genericRecipeDao.getRecipesByUserId(user.get(0).getUserId());
            req.setAttribute("recipeInfo", userRecipes);
        }
        if (req.getParameter("submit").equals("viewAll")) {
            req.setAttribute("recipeInfo", genericRecipeDao.getAll());
        }
        if (req.getParameter("submit").equals("viewById")) {
            Integer id = Integer.parseInt(req.getParameter("searchTerm"));
            req.setAttribute("recipeInfo", genericRecipeDao.getRecipesByUserId(id));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/recipeResults.jsp");
        dispatcher.forward(req, resp);

    }
}
