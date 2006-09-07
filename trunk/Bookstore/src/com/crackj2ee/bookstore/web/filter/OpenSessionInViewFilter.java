package com.crackj2ee.bookstore.web.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.logging.*;
import org.hibernate.Transaction;

import com.crackj2ee.bookstore.exception.NeedLoginException;
import com.crackj2ee.bookstore.raw.hibernate.HibernateUtil;
import com.crackj2ee.bookstore.util.HttpUtil;

/**
 * This filter implements OpenSessionInView pattern and JDBC transaction. 
 * No any other transaction is needed (Such as Spring TransactionProxyBean). 
 * It should and only should be used in a single JVM. Never use it when 
 * web application acrosses multiple JVMs.<br/>
 * 
 * If this filter is disabled, auto-login feature will be disabled, for cannot 
 * check username and password passed by cookie in filter. Only a hibernate 
 * session is opened, can check user's identity.
 * 
 * @author xuefeng
 */
public class OpenSessionInViewFilter implements Filter {

    private Log log = LogFactory.getLog(getClass());

    private boolean enable = false;

    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Init OpenSessionInViewFilter...");
        String sEnable = filterConfig.getInitParameter("enable");
        if(sEnable!=null) {
            enable = Boolean.valueOf(sEnable).booleanValue();
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(!enable) {
            chain.doFilter(request, response);
            return;
        }
        // using OpenSessionInView pattern:
        Transaction tx = null;
        try {
            log.info("Starting JDBC transaction...");
            // get Hibernate Session and let hibernate binds it to current thread:
            tx = HibernateUtil.getCurrentSession().beginTransaction();

            // try to auto login by cookies:
            //HttpUtil.autoLogin((HttpServletRequest)request, (HttpServletResponse)response);

            // Call the next filter (continue request processing)
            chain.doFilter(request, response);

            // Commit and cleanup
            log.info("Committing JDBC transaction");
            tx.commit();
        }
        catch (Throwable ex) {
            // Rollback only
            log.warn("Rollback transaction for exception: " + ex.getClass().getName());
            try {
                tx.rollback();
            }
            catch (Throwable rbEx) {
                log.error("Could not rollback transaction after exception!", rbEx);
            }
            // redirect or re-throw exception:
            if(ex instanceof NeedLoginException) {
                ((HttpServletResponse)response).sendRedirect("login.html?url=");
            }
            else {
                // Let others handle it...
                throw new ServletException(ex);
            }
        }
    }

    public void destroy() {
        log.info("OpenSessionInViewFilter destroyed.");
    }

}
