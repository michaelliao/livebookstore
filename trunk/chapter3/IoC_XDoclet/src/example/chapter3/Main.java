package example.chapter3;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application start entry.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        bindJndi();
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        System.out.println(context.getBean("pi"));
        System.out.println("Get system start time from JNDI: " + context.getBean("systemStartTime"));
        System.out.println("Get date: " + context.getBean("date"));
    }

    private static void bindJndi() throws Exception {
        LocateRegistry.createRegistry(1099);
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        System.setProperty(Context.PROVIDER_URL, "rmi://localhost:1099");
        InitialContext ctx = new InitialContext();
        class RemoteDate extends Date implements Remote {};
        ctx.bind("java:comp/env/systemStartTime", new RemoteDate());
        ctx.close();
    }
}
