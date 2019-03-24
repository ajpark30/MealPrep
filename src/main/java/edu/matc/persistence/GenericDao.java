package edu.matc.persistence;

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

        logger.info("**********Starting Get All Query From Class Type: " + type);
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
    public <T> T getById(int id) {

        logger.info("**********Query database by using an ID: " + id + ", of Type: " + type);
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        logger.info("**********Query by ID Found: " + entity);

        return entity;
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

        logger.info("**********Attempting to delete: " + entity);
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        logger.info("**********Successfully deleted: " + entity);

        transaction.commit();
        session.close();
    }

    /**
     * Gets userRecipes by userRecipes ID from the mealprep database
     * @param userRecipesId
     * @return userRecipes with the matching userRecipes id argument
     */
    public List<T> getRecipesByUserId(Integer userRecipesId) {

        logger.info("**********Querying user recipes by ID: " + userRecipesId);

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<Integer> propertyPath = root.get("user");
        query.where(builder.equal(propertyPath, userRecipesId));
        List<T> userRecipes = session.createQuery(query).getResultList();

        logger.info("**********Query found recipes by ID : " + userRecipes);

        session.close();

        return userRecipes;
    }

    /**
     * Returns an open session from the Session Factory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
