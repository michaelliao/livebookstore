package net.livebookstore.jmx;

/**
 * Define Sampler's MBean interface.
 * 
 * @author Xuefeng
 */
public interface SamplerMBean {

    long getTotal();
    long getCount();
    long getMax();
    long getAverage();

    void clear();

}
