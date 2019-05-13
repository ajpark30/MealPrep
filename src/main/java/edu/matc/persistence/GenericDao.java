package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Generic DAO that will allow access to all entity data
 *
 */
public class GenericDao<T> {

    private Class <T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new generic DAO
     * @param type
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets all entities
     * @return all of the entities
     */
    public List<T> getAll() {

        logger.info("**********Starting The Get All Query From Class Type: " + type);
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        logger.info("**********Get All Query Found: " + list);

        return list;
    }

    /**
     * Gets entity by ID
     * @param id entity ID to search by
     * @return entity
     */
    public <T> T getById(Integer id) {

        logger.info("**********Query database by using an ID: " + id + ", of Type: " + type);
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        logger.info("**********Query by ID Found: " + entity);

        return entity;
    }

    /**
     *
     * @param exactName
     * @return
     */
    public T getByExactName(String exactName) {
        logger.info("**********Querying Exact Name: " + exactName);

        Session session = getSession();
        session.clear();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("ingredientName");
        query.where(builder.equal(propertyPath, exactName));
        T foundObject = session.createQuery(query).getSingleResult();
        logger.info("**********Query Found Object by Exact Name: " + foundObject);
        session.close();

        return foundObject;
    }

    /**
     *
     * @param approximateName
     * @return
     */
    public T getByApproximateName(String columnName, String approximateName) {
        logger.info("**********Querying Approximate Name: " + approximateName);

        Session session = getSession();
        session.clear();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(columnName);
        query.where(builder.like(propertyPath, "%" + approximateName + "%"));
        T foundObject = session.createQuery(query).getSingleResult();
        logger.info("**********Query Found Object by Approximate Name: " + foundObject);
        session.close();
        return foundObject;
    }

    public List<T> getByUserName(String userName) {

        logger.info("**********Query database using the User Name: " + userName);
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("userName");
        query.where(builder.like(propertyPath, "%" + userName + "%"));
        List<T> list = session.createQuery(query).getResultList();
        logger.info("Found User Name: " + list);
        session.close();
        return list;
    }

    /**
     *
     * @param lastName
     * @return entity
     */
    public List<T> getByLastName(String lastName) {

        logger.info("**********Query Using Last Name:  " + lastName + ", of Type: " + type);
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        logger.info("**********Query by Last Name Found: " + list);

        return list;
    }

    /**
     *
     * @param entity
     * @return entity
     * TODO: Create some sort of catch if nothing is saved or updated
     */
    public <T> T saveOrUpdate(T entity) {

        logger.info("**********Attempting to Save|Update a Entity to the Database: " + entity);

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        logger.info("**********Saved|Updated entity: " + entity);
        session.close();

        return entity;
    }

    /**
     *
     * @param entity
     * @return entity
     * TODO: Create some sort of catch if nothing is inserted
     */
    public <T> T insert(T entity) {

        logger.info("**********Attempting to insert a Entity: " + entity);
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        logger.info("**********Entity inserted: " + entity);

        return entity;
    }



    /**
     * Deletes the entity
     *
     * @param entity to be deleted
     * TODO: Create some sort of catch if nothing is deleted
     */
    public void delete(T entity) {

        try {
            logger.info("**********Attempting to delete: " + entity);
            Session session = getSession();
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            logger.info("**********Successfully deleted: " + entity);
            transaction.commit();
            session.close();
        }catch (IllegalArgumentException i) {
            logger.error("**********Error while trying to delete entity: " + entity + " - " + i);
        }catch (Exception e) {
            logger.error("**********Error while trying to delete entity: " + entity + " - " + e);
        }
    }

    /**
     * Gets userRecipes by userRecipes ID from the mealprep database
     * @param userId
     * @return userRecipes with the matching userRecipes id argument
     */
    public List<T> getRecipesByUserId(Integer userId) {

        logger.info("**********Querying user recipes by ID: " + userId);

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<Integer> propertyPath = root.get("user");
        query.where(builder.equal(propertyPath, userId));
        List<T> userRecipes = session.createQuery(query).getResultList();
        logger.info("**********Query found recipes by ID : " + userRecipes);
        session.close();

        return userRecipes;
    }

    public List<T> getGrocerylistsByUserId(Integer userId) {
        logger.info("**********Querying grocery list by user id: " + userId);

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<Integer> propertyPath = root.get("user_id");
        query.where(builder.equal(propertyPath, userId));
        List<T> grocerylists = session.createQuery(query).getResultList();
        logger.info("*********Query found grocery lists by ID: " + grocerylists);
        session.close();

        return grocerylists;
    }

    /**
     *
     * @param nameOfGroceryList
     * @return
     */
    public List<T> getGrocerylistByItsName(String nameOfGroceryList) {
        logger.info("**********Querying grocery list by grocery list name: " + nameOfGroceryList);

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<Integer> propertyPath = root.get("grocerylistName");
        query.where(builder.equal(propertyPath, nameOfGroceryList));
        List<T> grocerylists = session.createQuery(query).getResultList();
        logger.info("**********Query found grocery lists by grocery list name: " + grocerylists);
        session.close();

        return grocerylists;
    }


    /**
     * Returns an open session from the Session Factory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
