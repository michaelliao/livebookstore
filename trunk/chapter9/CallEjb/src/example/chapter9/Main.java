package example.chapter9;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import samples.ejb.stateless.simple.ejb.*;

public class Main {

    public static void main(String[] args) {
        // Call EJB using JNDI lookup:
        GreeterHome home = getGreeterHome();
        try {
            Greeter greeter = home.create();
            System.out.println(greeter.getGreeting());
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }
        catch(CreateException e) {
            e.printStackTrace();
        }

        // Call EJB in Spring using customized interface:
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.cosnaming.CNCtxFactory");
        System.setProperty(Context.PROVIDER_URL, "iiop://localhost:3700");
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        MyGreeter greeter = (MyGreeter) context.getBean("greeter");
        System.out.println(greeter.getGreeting());
//        using remote interface:
//        Greeter greeter = (Greeter) context.getBean("greeter");
//        try {
//            System.out.println(greeter.getGreeting());
//        }
//        catch(RemoteException e) {}
    }

    private static GreeterHome homeCache = null;
    private static GreeterHome getGreeterHome() {
        if(homeCache==null) {
            InitialContext ctx = null;
            try {
                System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.cosnaming.CNCtxFactory");
                System.setProperty(Context.PROVIDER_URL, "iiop://localhost:3700");
                ctx = new InitialContext();
                Object ejbHome = ctx.lookup("greeter");
                homeCache = (GreeterHome) PortableRemoteObject.narrow(ejbHome, GreeterHome.class);
            }
            catch(Exception e) {
                throw new RuntimeException(e);
            }
            finally {
                if(ctx!=null) {
                    try {
                        ctx.close();
                    }
                    catch(NamingException e) {}
                }
            }
        }
        return homeCache;
    }
}
