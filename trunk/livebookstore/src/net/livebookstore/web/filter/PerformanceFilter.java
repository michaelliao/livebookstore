package net.livebookstore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.livebookstore.jmx.Sampler;
import net.livebookstore.util.HttpUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Test performance by sample each request process time.
 * 
 * @author Xuefeng
 * 
 * @spring.bean id="performanceFilter"
 */
public class PerformanceFilter implements Filter {

    public static final ThreadLocal<Long> businessPerf = new ThreadLocal<Long>();
    public static final ThreadLocal<Long> daoPerf = new ThreadLocal<Long>();

    private static final String START_TIME = "ST_PERF_FILTER";

    private final Log log = LogFactory.getLog(getClass());

    private Sampler httpSampler;
    private Sampler businessSampler;
    private Sampler daoSampler;

    /**
     * @spring.property ref="sampler:name=HttpSampler"
     */
    public void setHttpSampler(Sampler sampler) {
        this.httpSampler = sampler;
    }

    /**
     * @spring.property ref="sampler:name=BusinessSampler"
     */
    public void setBusinessSampler(Sampler sampler) {
        this.businessSampler = sampler;
    }

    /**
     * @spring.property ref="sampler:name=DaoSampler"
     */
    public void setDaoSampler(Sampler sampler) {
        this.daoSampler = sampler;
    }

    public void init(FilterConfig config) throws ServletException {
        /* Nothing to do */
    }

    public void destroy() {
        /* Nothing to do */
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        String url = HttpUtil.getURL((HttpServletRequest)request);
        if(url.endsWith("/checkState.jspx")) {
            chain.doFilter(request, response);
            return;
        }
        request.setAttribute(START_TIME, new Long(System.currentTimeMillis()));
        businessPerf.set(new Long(0));
        daoPerf.set(new Long(0));
        try {
            chain.doFilter(request, response);
        }
        finally {
            long httpTime = System.currentTimeMillis() - ((Long)request.getAttribute(START_TIME)).longValue();
            long businessTime = businessPerf.get().longValue();
            long daoTime = daoPerf.get().longValue();
            long businessPercent = httpTime==0 ? 0 : businessTime * 100 / httpTime;
            long daoPercent = httpTime==0 ? 0 : daoTime * 100 / httpTime;
            httpSampler.sample(httpTime);
            businessSampler.sample(businessTime);
            daoSampler.sample(daoTime);
            log.info(url + " execution: " + httpTime + "ms.");
            log.info("Business execution: " + businessTime + "ms, " + businessPercent + "%");
            log.info("Dao execution: " + daoTime + "ms, " + daoPercent + "%");
            businessPerf.remove();
            daoPerf.remove();
        }
    }

}
