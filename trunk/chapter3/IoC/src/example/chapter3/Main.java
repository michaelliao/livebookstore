package example.chapter3;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Application start entry.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // 初始化JNDI:
        bindJndi();

        // 实例化Spring容器:
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        XmlBeanFactory factory = new XmlBeanFactory(
                new ClassPathResource("config.xml"));
        factory.addBeanPostProcessor(new MyBeanPostProcessor());

        // 测试BookService:
        BookService bookService = (BookService) context.getBean("bookService");
        System.out.println("\n>> bookService.listAll");
        List<Book> books = bookService.listAll();
        for(Book book : books)
            System.out.println(book);
        System.out.println("\n>> bookService.listBooksByAuthor");
        List<Book> bks = bookService.listBooksByAuthor("Rod Johnson");
        for(Book book : bks)
            System.out.println(book);

        // 测试prototype作用域的date，调用3次，间隔10秒:
        System.out.println("\n>> getBean(\"date\")");
        System.out.println(context.getBean("date"));
        //Thread.sleep(10000);
        System.out.println(context.getBean("date"));
        //Thread.sleep(10000);
        System.out.println(context.getBean("date"));

        // 测试静态工厂，可以修改random的作用域比较运行结果:
        System.out.println("\n>> getBean(\"random\")");
        System.out.println("Random: " + context.getBean("random"));
        System.out.println("Random: " + context.getBean("random"));
        System.out.println("Random: " + context.getBean("random"));

        // 测试实例工厂instanceFactoryBean:
        System.out.println("\n>> instanceFactoryBean");
        System.out.println(context.getBean("instanceFactoryBean"));
        System.out.println(context.getBean("currentTime"));

        // 测试FactoryBean:
        System.out.println("\n>> piFactoryBean");
        if(context.getBean("pi")==context.getBean("pi"))
            System.out.println("pi = " + context.getBean("pi"));
        System.out.println("&pi = " + context.getBean("&pi"));

        // 测试JndiObjectFactoryBean:
        System.out.println("\n>> Get system start time from getBean(\"systemStartTime\")");
        System.out.println(context.getBean("systemStartTime"));
        System.out.println("\n>> Get system start time from jndi lookup");
        System.out.println(jndiLookup());

        // 测试基于模板配置的Employee:
        System.out.println("\n>> Test abstract bean");
        Employee engineer1 = (Employee) context.getBean("engineer1");
        System.out.println(engineer1.getName());
        Employee engineer2 = (Employee) context.getBean("engineer2");
        System.out.println(engineer2.getName());
        Employee manager = (Employee) context.getBean("manager");
        System.out.println(manager.getName() + " at " + manager.getDepartment());
        // 试图获取abstractEmployee将抛BeanIsAbstractException异常:
        //context.getBean("abstractEmployee");

        // 测试MyBeanPostProcessor对BasicBean的修改:
        System.out.println("\n>> Test myBeanPostProcessor");
        BasicBean basicBean = (BasicBean) context.getBean("basicBean");
        System.out.println(basicBean.getTitle());

        // 测试发布/接收事件:
        System.out.println("\n>> Test event");
        MessagePublisher messagePublisher = (MessagePublisher)context.getBean("messagePublisher");
        messagePublisher.sendMessage("Hello, everyone!");
        System.out.println("Application end.");
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

    private static Object jndiLookup() {
        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
            return ctx.lookup("java:comp/env/systemStartTime");
        }
        catch(NamingException ne) {
            throw new RuntimeException(ne);
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
}
