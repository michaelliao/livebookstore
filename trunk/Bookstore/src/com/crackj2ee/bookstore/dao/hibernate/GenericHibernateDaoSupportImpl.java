package com.crackj2ee.bookstore.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

import org.apache.commons.logging.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.crackj2ee.bookstore.domain.*;

/**
 * This base class is prepared for subclass to do CRUD easily.
 * 
 * @author xuefeng
 */
public abstract class GenericHibernateDaoSupportImpl<T> {

    protected Log log = LogFactory.getLog(getClass());

    private Class clazz;
    protected HibernateTemplate hibernateTemplate;

    /**
     * Inject domain's class type in constructor.
     * 
     * @param clazz Domain's class.
     */
    public GenericHibernateDaoSupportImpl(Class clazz) {
        this.clazz = clazz;
    }

    /**
     * @spring.property name="hibernateTemplate" ref="hibernateTemplate"
     */
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @SuppressWarnings("unchecked")
    public T query(Serializable id) {
        return (T)hibernateTemplate.load(clazz, id);
    }

    /**
     * Default implementation of creating new domain object.
     */
    public void create(T t) {
        hibernateTemplate.save(t);
    }

    /**
     * Default implementation of deleting new domain object.
     */
    public void delete(T t) {
        hibernateTemplate.delete(t);
    }

    /**
     * Default implementation of updating domain object.
     */
    public void update(T t) {
        hibernateTemplate.update(t);
    }

    /**
     * Prepared for sub-class for convenience.
     */
    protected List queryForList(final String selectCount, final String select, final Object[] values, final Page page) {
        HibernateCallback countCallback = new HibernateCallback() {
            public Object doInHibernate(Session session) {
                Query query = session.createQuery(selectCount);
                if(values!=null) {
                    for(int i=0; i<values.length; i++) {
                        query.setParameter(i, values[i]);
                    }
                }
                return query.uniqueResult();
            }
        };
        Long count = (Long)hibernateTemplate.execute(countCallback);
        page.setTotalCount(count.intValue());
        if(page.isEmpty())
            return Collections.EMPTY_LIST;
        // select:
        HibernateCallback selectCallback = new HibernateCallback() {
            public Object doInHibernate(Session session) {
                Query query = session.createQuery(selectCount);
                if(values!=null) {
                    for(int i=0; i<values.length; i++) {
                        query.setParameter(i, values[i]);
                    }
                }
                return query.setFirstResult(page.getFirstResult())
                            .setMaxResults(page.getPageSize())
                            .list();
            }
        };
        return (List) hibernateTemplate.executeFind(selectCallback);
    }

    protected Object queryForObject(final String select, final Object[] values) {
        HibernateCallback selectCallback = new HibernateCallback() {
            public Object doInHibernate(Session session) {
                Query query = session.createQuery(select);
                if(values!=null) {
                    for(int i=0; i<values.length; i++) {
                        query.setParameter(i, values[i]);
                    }
                }
                return query.uniqueResult();
            }
        };
        return hibernateTemplate.execute(selectCallback);
    }

    protected Object queryForObject(final DetachedCriteria dc) {
        HibernateCallback callback = new HibernateCallback() {
            public Object doInHibernate(Session session) {
                return dc.getExecutableCriteria(session).uniqueResult();
            }
        };
        return hibernateTemplate.execute(callback);
    }

    /**
     * Prepared for sub-class for convenience.
     */
    protected List queryForList(final DetachedCriteria dc, final Page page) {
        HibernateCallback callback = new HibernateCallback() {
            public Object doInHibernate(Session session) {
                Criteria c = dc.getExecutableCriteria(session);
                if(page==null)
                    return c.list();
                return PaginationCriteria.query(c, page);
            }
        };
        return hibernateTemplate.executeFind(callback);
    }

    /**
     * Prepared for sub-class for convenience.
     */
    protected Object uniqueResult(final DetachedCriteria dc) {
        HibernateCallback callback = new HibernateCallback() {
            public Object doInHibernate(Session session) {
                return dc.getExecutableCriteria(session).uniqueResult();
            }
        };
        return hibernateTemplate.execute(callback);
    }

}

/**
 * A PaginationCriteria can execute both "select count(*)" and 
 * "select * from" queries, and set Page object automatically. 
 * This class uses reflect to remove and restore "order by" conditions.
 * 
 * @author Xuefeng
 */
class PaginationCriteria {

    private static Log log = LogFactory.getLog(PaginationCriteria.class);

    public static List query(Criteria c, Page page) {
        // first we must detect if any Order defined:
        // private List orderEntries = new ArrayList();
        Field orderEntriesField = getField(c, "orderEntries");
        orderEntriesField.setAccessible(true);
        List _old_orderEntries = (List)getFieldValue(orderEntriesField, c);
        boolean restore = false;
        if(_old_orderEntries.size()>0) {
            restore = true;
            setFieldValue(orderEntriesField, c, new ArrayList());
        }
        c.setProjection(Projections.rowCount());
        int rowCount = ((Long)c.uniqueResult()).intValue();
        page.setTotalCount(rowCount);
        if(rowCount==0) {
            // no need to execute query:
            return Collections.EMPTY_LIST;
        }
        // query:
        if(restore) {
            // restore order conditions:
            setFieldValue(orderEntriesField, c, _old_orderEntries);
        }
        return c.setFirstResult(page.getFirstResult())
                .setMaxResults(page.getPageSize())
                .setFetchSize(page.getPageSize())
                .list();
    }

    private static Field getField(Object obj, String fieldName) {
        try {
            return obj.getClass().getDeclaredField(fieldName);
        }
        catch (Exception e) {
            log.warn("Class.getDeclaredField(String) failed.", e);
            throw new RuntimeException(e);
        }
    }

    private static Object getFieldValue(Field field, Object obj) {
        field.setAccessible(true);
        try {
            return field.get(obj);
        }
        catch (Exception e) {
            log.warn("Field.get(Object) failed.", e);
            throw new RuntimeException(e);
        }
    }

    private static void setFieldValue(Field field, Object target, Object value) {
        field.setAccessible(true);
        try {
            field.set(target, value);
        }
        catch (Exception e) {
            log.warn("Field.set(Object, Object) failed.", e);
            throw new RuntimeException(e);
        }
    }
}
