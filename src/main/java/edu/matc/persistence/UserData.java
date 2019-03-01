package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author apark
 */
public class UserData {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *
     * @param firstName
     * @param lastName
     * @return the users by first and last name
     */
    public List<User> getUserByName(String firstName, String lastName) {

        String sql = null;

        if (firstName != null && lastName != null){
            sql = "SELECT * FROM users WHERE firstname ='" + firstName + "' AND lastname='" + lastName + "'";
            logger.info("Querying database using query: " + sql);
        }

        return executeQuery(sql);
    }

    /**
     *
     * @return all users in database
     */
    public List<User> getAllUsers() {

        String sql = "SELECT * FROM users";
        logger.info("Querying database using query: " + sql);
        return executeQuery(sql);
    }


    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();

        user.setUserId(results.getInt("user_id"));
        user.setFirstName(results.getString("firstname"));
        user.setLastName(results.getString("lastname"));
        user.setUserName(results.getString("user_name"));

        return user;
    }

    /**
     * Executes the query passed in and returns a list of users
     * @param  sql
     * @return list of users
     */
    private List<User> executeQuery(String sql) {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            System.out.println("SearchUserPage.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("SearchUserPage.getAllUsers()...Exception: " + e);
        }

        return users;
    }
}