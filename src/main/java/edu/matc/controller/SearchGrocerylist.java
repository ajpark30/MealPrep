package edu.matc.controller;

import edu.matc.entity.GroceryList;
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
        name = "SearchGrocerylist",
        urlPatterns = {"/searchGrocerylist"}
)

public class SearchGrocerylist extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao genericUserDao = new GenericDao(User.class);
        GenericDao genericGroceryListDao = new GenericDao(GroceryList.class);

        if (req.getParameter("submit").equals("viewByLastName")) {
            String lastname = req.getParameter("searchLastName");
            List<User> user = genericUserDao.getByLastName(lastname);
            List<GroceryList> groceryListsByLastName = genericGroceryListDao.getGrocerylistsByUserId(user.get(0).getUserId());
            logger.info("Grocery List Object Results from Search by Last Name: " + groceryListsByLastName);
            req.setAttribute("grocerylistInfo", groceryListsByLastName);
        }
        if (req.getParameter("submit").equals("viewByGroceryListName")) {
            String groceryListName = req.getParameter("searchGroceryListName");
            List<GroceryList> groceryListsByName = genericGroceryListDao.getGrocerylistByItsName(groceryListName);
            logger.info("Grocery List Object Results from Search by Grocery List Name: " + groceryListsByName);
            req.setAttribute("grocerylistInfo", groceryListsByName);
        }
        //This is pulling all grocery lists, I need to scope it to just the user
        if (req.getParameter("submit").equals("viewAll")) {
            req.setAttribute("grocerylistInfo", genericGroceryListDao.getAll());
        }
        if (req.getParameter("submit").equals("viewByGrocerylistName")) {
            String grocerylistName = req.getParameter("searchTerm");
            req.setAttribute("grocerylistInfo", genericGroceryListDao.getGrocerylistByItsName(grocerylistName));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/searchForGrocerylistResults.jsp");
        dispatcher.forward(req, resp);

    }
}

