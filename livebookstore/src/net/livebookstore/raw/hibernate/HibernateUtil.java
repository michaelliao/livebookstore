package net.livebookstore.raw.hibernate;

import org.apache.commons.logging.*;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * HibernateUtil for non-spring managed Hibernate session. Not used.
 * 
 * @author xuefeng
 * 
 * @deprecated
 */
public final class HibernateUtil {

    private static Log log;
    private static SessionFactory sessionFactory;

    static {
        log = LogFactory.getLog(HibernateUtil.class);
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch(Exception e) {
            e.printStackTrace();
            log.error("Error init SessionFactory.", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Get instance of Hibernate SessionFactory.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Get current Hibernate session by calling SessionFactory.getCurrentSession().
     */
    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
