package example.chapter9;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class Main {

    public static void main(String[] args) throws Exception {
        Hello hello = new Hello();
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        server.registerMBean(hello, new ObjectName("test:name=Hello"));
        hello.addNotificationListener(new HelloNotificationListener(), null, null);
        Thread.sleep(Long.MAX_VALUE);
    }

}
