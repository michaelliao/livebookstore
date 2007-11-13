package example.chapter2;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringStartup {

    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        HelloWorld hello = (HelloWorld)factory.getBean("hello");
        System.out.println(hello.say());
        factory.destroySingletons();
    }

}
