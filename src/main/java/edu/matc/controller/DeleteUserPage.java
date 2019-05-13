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

            GenericDao<User> userGenericDao = new GenericDao(User.class);
            User userToDelete = userGenericDao.getById(Integer.parseInt(req.getParameter("userId")));
            if(!userToDelete.getUserName().isEmpty()) {
                userGenericDao.delete(userToDelete);
                logger.info("User ID requested to delete: " + userToDelete);
                req.setAttribute("deletedUserName", userToDelete.getUserName());
            } else {
                req.setAttribute("errorId", req.getParameter("userId"));
            }
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/deletedUserResult.jsp");
        dispatcher.forward(req, resp);
    }
}
