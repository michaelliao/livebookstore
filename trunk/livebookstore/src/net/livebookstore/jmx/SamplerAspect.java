package net.livebookstore.jmx;

import net.livebookstore.web.filter.PerformanceFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Aspect for Sampler.
 * 
 * @spring.bean id="samplerAspect"
 * 
 * @author Xuefeng
 */
@Aspect
public class SamplerAspect {

    private Log log = LogFactory.getLog(getClass());

    private Object doSample(ProceedingJoinPoint pjp, ThreadLocal<Long> tl) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return pjp.proceed();
        }
        finally {
            long last = System.currentTimeMillis() - start;
            log.info("doSample execute " + last + "ms.");
            Long acc = tl.get();
            if(acc!=null)
                tl.set(new Long(acc.longValue() + last));
        }
    }

    @Around("execution(* net.livebookstore.business.BusinessService.*(..))")
    public Object businessExecution(ProceedingJoinPoint pjp) throws Throwable {
        return doSample(pjp, PerformanceFilter.businessPerf);
    }

    @Around("execution(* net.livebookstore.dao.*Dao.*(..))")
    public Object daoExecution(ProceedingJoinPoint pjp) throws Throwable {
        return doSample(pjp, PerformanceFilter.daoPerf);
    }

}
