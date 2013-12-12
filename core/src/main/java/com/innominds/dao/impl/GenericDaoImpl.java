package com.innominds.dao.impl;

/*
 * Singleton class to create any kind of DAO
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.innominds.dao.GenericDao;

/**
 * The Class GenericDaoImpl.
 *
 * @param <T>
 *            the generic type
 * @param <PK>
 *            the generic type
 */
@SuppressWarnings("rawtypes")
@Repository("genericDao")
@Transactional()
public class GenericDaoImpl<T, PK> implements GenericDao {

	
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.lyris.dataaccess.GenericDao#create(com.lyris.core.data.service.thrift
     * .gen.DataAccessServiceContext, java.lang.Object)
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly=false)
    public Object create(Object newInstance) {
        T rtn = null;
        try {
            rtn = em.merge((T) newInstance);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
        return rtn;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.lyris.dataaccess.GenericDao#get(com.lyris.core.data.service.thrift
     * .gen.DataAccessServiceContext, java.lang.Class, java.io.Serializable)
     */
    public Object get(Class type, Serializable id) {
        Object rtn = null;
        if (em != null) {
            try {
                rtn = em.find(type, id);
                // em.detach(rtn);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                em.close();
            }
        }
        return rtn;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.lyris.dataaccess.GenericDao#update(com.lyris.core.data.service.thrift
     * .gen.DataAccessServiceContext, java.lang.Object)
     */
    public Object update(Object transientObject) {
        return create(transientObject);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.lyris.dataaccess.GenericDao#delete(com.lyris.core.data.service.thrift
     * .gen.DataAccessServiceContext, java.lang.Class, java.io.Serializable)
     */
    public void delete(Class type, Serializable id) {
        if (em != null) {
            synchronized (em) {
                try {
                    Object o = em.getReference(type, id);
                    em.remove(o);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    em.close();
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.lyris.dataaccess.GenericDao#getObjects(com.lyris.core.data.service
     * .thrift.gen.DataAccessServiceContext, java.lang.Class, java.lang.String)
     */
    public List getObjects(Class type, String queryString) {
        List items = new ArrayList();
        if (em != null) {
            try {
                Query query = em.createQuery("SELECT o FROM " + type.getName() + " o "
                        + (queryString == null || queryString.isEmpty() ? "" : " WHERE " + queryString));
                items = query.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                em.close();
            }
        }
        return items;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.lyris.dataaccess.GenericDao#getObjects(com.lyris.core.data.service
     * .thrift.gen.DataAccessServiceContext, java.lang.Class, java.lang.String)
     */
    public List searchObjects(Class type, String queryString, String[] queryParams) {
        List items = new ArrayList();

        if (em != null) {
            try {
                Query query = em.createQuery("SELECT o FROM " + type.getName() + " o "
                        + (queryString == null || queryString.isEmpty() ? "" : " WHERE " + queryString));
                if (queryString != null && !queryString.isEmpty()) {
                    int i = 0;
                    for (String queryParam : queryParams) {
                        query.setParameter(++i, queryParam);
                    }
                }
                items = query.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                em.close();
            }
        }
        return items;
    }

    public List<Object> getConfinedObjects(Class type, String queryString, int offset, int limit) {
        List items = new ArrayList();
        if (em != null) {
            try {
                Query query = em.createQuery("SELECT o FROM " + type.getName() + " o "
                        + (queryString == null || queryString.isEmpty() ? "" : " WHERE " + queryString));
                query.setFirstResult(offset).setMaxResults(limit).getResultList();
                items = query.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                em.close();
            }
        }
        return items; // return entityManager().createQuery("from Model m", Model.class).setFirstResult(offset).setMaxResults(max).getResultList();
    }

    public List getCustomObjects(Class type, String columns, String queryString) {
        List items = new ArrayList();
        if (em != null) {
            try {
                Query query = em.createQuery("SELECT " + columns + " FROM " + type.getName()
                        + (queryString == null || queryString.isEmpty() ? "" : " WHERE " + queryString));
                items = query.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                em.close();
            }
        }
        return items;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.lyris.dataaccess.GenericDao#removeObjectUsingCompositeKey(com.lyris
     * .core.data.service.thrift.gen.DataAccessServiceContext, java.lang.Class,
     * java.lang.Object)
     */
    public void removeObjectUsingCompositeKey(Class type, Object compositeId) {
        if (em != null) {
            try {
                Object o = em.getReference(type, compositeId);
                em.remove(o);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                em.close();
            }
        }

    }

    public List getEntitiesByNativeQuery(String queryString, Class type) {
        List items = new ArrayList();
        if (em != null) {
            try {
                Query query = em.createNativeQuery(queryString, type);
                items = query.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                em.close();
            }
        }
        return items;
    }

   
}
