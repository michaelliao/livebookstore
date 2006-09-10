package com.crackj2ee.bookstore.raw.hibernate;

import javax.servlet.http.*;

import org.hibernate.Transaction;
import org.springframework.web.servlet.*;


/**
 * This interceptor used to open transaction at the beginning of request-processing, 
 * and end transaction after got model but NOT rendered view yet.<br/>
 * The purpose of this interceptor is to end transaction as soon as possible, 
 * if NOT use lazy-loading.
 * 
 * @author xuefeng
 * 
 * spring.bean id="hibernateTransactionHandlerInterceptor"
 * 
 * @deprecated
 */
public class HibernateTransactionHandlerInterceptor implements HandlerInterceptor {

    // store transaction with thread to make this interceptor stateless,
    // so that all methods are thread-safe:
    private static final ThreadLocal<Transaction> threadTx = new ThreadLocal<Transaction>();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Transaction tx = HibernateUtil.getCurrentSession().beginTransaction();
        threadTx.set(tx);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {
        /* Empty */
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        if(e==null) {
            // no exception, commit transaction:
            threadTx.get().commit();
        }
        else {
            // rollback:
            threadTx.get().rollback();
        }
        threadTx.set(null);
    }

}
