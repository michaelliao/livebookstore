package net.livebookstore.web.mbean;

import java.util.concurrent.atomic.AtomicLong;

public class HttpMBean {

    private AtomicLong requestTotalTime = new AtomicLong(0);
    private AtomicLong requestCount = new AtomicLong(0);
    private long average = 0;

    public void addRequest(long time) {
        long total = requestTotalTime.addAndGet(time);
        long count = requestCount.incrementAndGet();
        average = total / count;
    }

    public long getAverageTime() {
        return average;
    }

    public long getRequestCount() {
        return requestCount.longValue();
    }

}
