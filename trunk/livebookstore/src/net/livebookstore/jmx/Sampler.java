package net.livebookstore.jmx;

/**
 * Performance sampler, to detect performance issue.
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="sampler:name=HttpSampler"
 * @spring.bean name="sampler:name=BusinessSampler"
 * @spring.bean name="sampler:name=DaoSampler"
 */
public class Sampler implements SamplerMBean {

    private transient long total;
    private transient long count;
    private transient long max;

    public long getTotal() { return total; }
    public long getCount() { return count; }
    public long getMax() { return max; }

    public long getAverage() {
        return count==0 ? 0 : total / count;
    }

    public final void clear() {
        total = count = max = 0;
    }

    public final void sample(long time) {
        total += time;
        count ++;
        max = (time>max) ? time : max;
    }

}
