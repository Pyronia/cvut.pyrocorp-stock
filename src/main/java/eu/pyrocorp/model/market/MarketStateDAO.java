package eu.pyrocorp.model.market;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Michal Hubálek.
 */
public class MarketStateDAO
{
    private static MarketStateDAO instance;
    private EntityManager entityManager;

    private MarketStateDAO()
    {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager()
    {
        if (entityManager == null)
        {
            entityManager = Persistence.createEntityManagerFactory("PERSISTENCE").createEntityManager();
        }

        return entityManager;
    }

    public static MarketStateDAO getInstance()
    {
        if (instance == null)
        {
            instance = new MarketStateDAO();
        }

        return instance;
    }

    public MarketState getByKey(final MarketStateKey key)
    {
        return entityManager.find(MarketState.class, key);
    }

    public List<MarketState> findAll()
    {
        return entityManager.createQuery("FROM " + MarketState.class.getName()).getResultList();
    }

    public void persist(MarketState marketState)
    {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.persist(marketState);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(MarketState marketState)
    {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.merge(marketState);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(MarketState marketState)
    {
        try
        {
            entityManager.getTransaction().begin();
            marketState = entityManager.find(MarketState.class, marketState.getMarketStateKey());
            entityManager.remove(marketState);
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeByKey(final MarketStateKey key)
    {
        try
        {
            remove(getByKey(key));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
