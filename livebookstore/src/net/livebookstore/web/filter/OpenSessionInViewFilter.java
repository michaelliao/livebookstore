package net.livebookstore.web.filter;

import java.io.IOException;

import javax.servlet.*;

import org.apache.commons.logging.*;
import org.hibernate.Transaction;

import net.livebookstore.raw.hibernate.HibernateUtil;

/**
 * This filter implements OpenSessionInView pattern and Hibernate transaction. 
 * No any other transaction is needed (Such as Spring TransactionProxyBean). 
 * It should and only should be used in a single JVM. Never use it when 
 * web application acrosses multiple JVMs.<br />
 * 
 * NOTE: DO NOT use spring-managed Hibernate. It only worked with HibernateUtil 
 * and with Thread-bind Session.
 * 
 * @author xuefeng
 * 
 * @deprecated
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
            // get Hibernate Session and let hibernate binds it to current thread:
            log.info("Hibernate transaction forcurrent session: about to begin...");
            tx = HibernateUtil.getCurrentSession().beginTransaction();

            // try to auto login by cookies:
            //HttpUtil.autoLogin((HttpServletRequest)request, (HttpServletResponse)response);

            // Call the next filter (continue request processing)
            chain.doFilter(request, response);

            // Commit and cleanup
            log.info("Hibernate transaction for current session: about to commit...");
            tx.commit();
        }
        catch (Throwable ex) {
            // Rollback only
            log.info("Hibernate transaction for current session: about to rollback...", ex);
            try {
                tx.rollback();
            }
            catch (Throwable rbEx) {
                log.error("Could not rollback hibernate transaction after exception!", rbEx);
            }
            // Let others handle it...
            throw new ServletException(ex);
        }
    }

    public void destroy() {
        log.info("OpenSessionInViewFilter destroyed.");
    }

}
