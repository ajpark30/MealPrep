package edu.matc.controller;

import edu.matc.entity.User;
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
        name = "AddUserPage",
        urlPatterns = {"/addUser"}
)

public class AddUserPage extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        if (req.getParameter("submit").equals("submit")) {

            User user = new User();

            user.setFirstName(req.getParameter("firstName"));
            user.setLastName(req.getParameter("lastName"));
            user.setUserName(req.getParameter("userName"));
            user.setUserPassword(req.getParameter("password"));

            req.setAttribute("addedUserName", userDao.saveOrUpdate(user));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/addedUserResult.jsp");
        dispatcher.forward(req, resp);
    }
}
