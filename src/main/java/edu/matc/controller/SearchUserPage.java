package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Add docs here
 * @author Andrew Park
 */

@WebServlet(
        name = "SearchUserPage",
        urlPatterns = {"/searchUser"}
)

public class SearchUserPage extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao = new UserDao();

        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("userInfo", userDao.getUserByLastName(req.getParameter("searchTerm")));
        }
        if (req.getParameter("submit").equals("viewAll")) {
            req.setAttribute("userInfo", userDao.getAllUsers());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);

    }
}
