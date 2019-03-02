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
 * Bean to request form data for a user delete from the database
 * @author Andrew Park
 */

@WebServlet(
        name = "DeleteUserPage",
        urlPatterns = {"/deleteUser"}
)

public class DeleteUserPage extends HttpServlet{
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("submitDelete").equals("submitDelete")) {

            UserDao userDao = new UserDao();

            User userToDelete = userDao.getUserById(Integer.parseInt(req.getParameter("userId")));

            logger.info("User ID requested to delete: " + userToDelete);
            req.setAttribute("deletedUserName", userDao.delete(userToDelete));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/deletedUserResult.jsp");
        dispatcher.forward(req, resp);
    }
}
