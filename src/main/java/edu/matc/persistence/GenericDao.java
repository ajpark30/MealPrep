package edu.matc.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();

        return list;
    }

}
