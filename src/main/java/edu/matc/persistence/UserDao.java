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

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();

        session.close();
        logger.info("Querying: " + query.toString());
        logger.info("Found: " + users);
        return users;
    }

    /**
     * Gets users by last name from the mealprep database
     * @param lastName
     * @return all users with the last name
     */
    public List<User> getUserByLastName(String lastName) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        List<User> users = session.createQuery(query).getResultList();

        session.close();
        logger.info("Querying: " + query.toString());
        logger.info("Found: " + users);
        return users;
    }

    /**
     * Add new user into the mealprep database
     * @param firstName
     * @param lastName
     * @param userName
     * @param userPassword
     */
    public Integer addNewUser(String firstName, String lastName, String userName, String userPassword) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer userId = null;

        try {
            tx = session.beginTransaction();
            User user = new User(firstName, lastName, userName, userPassword);
            userId = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            logger.error("HibernateException: " + e);
        } finally {
            session.close();
        }
        return userId;
    }
}
