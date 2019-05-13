package edu.matc.controller;

import edu.matc.entity.User;
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
        name = "AddUserPage",
        urlPatterns = {"/addUser"}
)

public class AddUserPage extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<User> userGenericDao = new GenericDao(User.class);

        if (req.getParameter("submit").equals("submit")) {

            User user = new User();

            user.setFirstName(req.getParameter("firstName"));
            user.setLastName(req.getParameter("lastName"));
            user.setUserName(req.getParameter("userName"));
            user.setUserPassword(req.getParameter("password"));
            logger.info("User requested to add: " + user);
            req.setAttribute("addedUserName", userGenericDao.insert(user));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/addedUserResult.jsp");
        dispatcher.forward(req, resp);
    }
}
