package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRecipes;
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

public class UserRecipesDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    UserDao userDao;

    /**
     * Gets all userRecipes from mealprep database
     *
     * @return all userRecipes in database
     */
    public List<UserRecipes> getAllUserRecipes() {

        logger.info("**********Querying all UserRecipes." );

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserRecipes> query = builder.createQuery(UserRecipes.class);
        Root<UserRecipes> root = query.from(UserRecipes.class);
        List<UserRecipes> userRecipes = session.createQuery(query).getResultList();

        logger.info("**********Query Found UserRecipes: " + userRecipes);

        session.close();

        return userRecipes;
    }

    /**
     * Gets userRecipes by userRecipes ID from the mealprep database
     * @param userRecipesId
     * @return userRecipes with the matching userRecipes id argument
     */
    public List<UserRecipes> getUserRecipesById(Integer userRecipesId) {

        logger.info("**********Querying user recipes by ID: " + userRecipesId);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserRecipes> query = builder.createQuery(UserRecipes.class);
        Root<UserRecipes> root = query.from(UserRecipes.class);
        Expression<Integer> propertyPath = root.get("user");
        query.where(builder.equal(propertyPath, userRecipesId));
        List<UserRecipes> userRecipes = session.createQuery(query).getResultList();

        logger.info("**********Query found recipes by ID : " + userRecipes);

        session.close();

        return userRecipes;
    }

    /**
     * Gets userRecipes by last name from the mealprep database
     * @param lastName
     * @return all userRecipes with the last name
     */
    public List<UserRecipes> getUserRecipesByLastName(String lastName) {

        List<UserRecipes> list = getAllUserRecipes();
        logger.info("**********Recieved lastname for recipe search: " + lastName);
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        List<User> users = session.createQuery(query).getResultList();

        logger.info("**********User Found by lastname: " + users);
        logger.info("**********Grabbing user ID to find users recipes in database: " + users.get(0).getUserId());
        List<UserRecipes> recipesByLastName = getUserRecipesById(users.get(0).getUserId());

        session.close();

        return recipesByLastName;
    }

    /**
     * update userRecipes
     * @param userRecipes  UserRecipes to be inserted or updated
     */
    public String saveOrUpdate(UserRecipes userRecipes) {

        logger.info("**********Attempting to save|update a user recipe into the database: " + userRecipes);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(userRecipes);
        transaction.commit();

        logger.info("**********Saved|Updated a user recipe: " + userRecipes.getRecipeTitle() + " with ID: " + userRecipes.getRecipeId());

        session.close();

        return userRecipes.getRecipeTitle();
    }

    /**
     * update userRecipes
     * @param userRecipes  UserRecipes to be inserted or updated
     * @return id of the inserted userRecipes
     */
    public UserRecipes insertUserRecipes(UserRecipes userRecipes) {

        logger.info("**********Attempting to insert a user recipe into the database: " + userRecipes);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(userRecipes);
        transaction.commit();

        logger.info("**********User recipe inserted: " + userRecipes.getUser() + " with ID: " + userRecipes.getRecipeId());

        session.close();

        return userRecipes;
    }

    /**
     * Delete a userRecipes
     * @param userRecipes UserRecipes to be deleted
     */
    public String delete(UserRecipes userRecipes) {

        List<UserRecipes> userRecipesToDelete = getUserRecipesById(userRecipes.getRecipeId());

        logger.info("**********Attempting to delete a user recipe from database: " + userRecipesToDelete + " with ID: " + userRecipesToDelete);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userRecipesToDelete);
        transaction.commit();

        logger.info("**********Successfully deleted a user recipe: " + userRecipesToDelete + " with ID: " + userRecipesToDelete);

        session.close();

        return userRecipesToDelete.toString();
    }
}
