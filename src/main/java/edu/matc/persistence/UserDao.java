package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all users from mealprep database
     *
     * @return all users in database
     */
    public List<User> getAllUsers() {

        logger.info("**********Querying all Users." );

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();

        logger.info("**********Query Found Users: " + users);

        session.close();

        return users;
    }

    /**
     * Gets users by user ID from the mealprep database
     * @param userId
     * @return user with the matching user id argument
     */
    public User getUserById(Integer userId) {

        logger.info("**********Querying User by ID: " + userId);

        Session session = sessionFactory.openSession();
        User user = session.get(User.class, userId);

        logger.info("**********Query Found ID : " + userId);

        session.close();

        return user;
    }

    /**
     * Gets users by last name from the mealprep database
     * @param lastName
     * @return all users with the last name
     */
    public List<User> getUserByLastName(String lastName) {

        logger.info("**********Querying User by Last Name: " + lastName);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        List<User> users = session.createQuery(query).getResultList();

        logger.info("**********Querying Found: " + users);

        session.close();

        return users;
    }

    /**
     * update user
     * @param user  User to be inserted or updated
     */
    public String saveOrUpdate(User user) {

        logger.info("**********Attempting to save|update user into the database: " + user);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();

        logger.info("**********Saved|Updated user: " + user.getUserName() + " With ID: " + user.getUserId());

        session.close();

        return user.getUserName();
    }

    /**
     * update user
     * @param user  User to be inserted or updated
     * @return id of the inserted user
     */
    public User insertUser(User user) {

        logger.info("**********Attempting to insert a user into the database: " + user);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();

        logger.info("**********User inserted: " + user.getUserName() + " with user ID: " + user.getUserId());

        session.close();

        return user;
    }

    /**
     * Delete a user
     * @param user User to be deleted
     */
    public String delete(User user) {

        User userToDelete = getUserById(user.getUserId());

        logger.info("**********Attempting to delete user from database: " + userToDelete.getUserName() + " with ID: " + userToDelete.getUserId());

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userToDelete);
        transaction.commit();

        logger.info("**********Successfully deleted user: " + userToDelete.getUserName() + " with ID: " + userToDelete.getUserId());

        session.close();

        return userToDelete.getUserName();
    }
}
