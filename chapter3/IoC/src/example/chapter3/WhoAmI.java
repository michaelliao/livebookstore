package example.chapter3;

import org.springframework.beans.factory.BeanNameAware;

public class WhoAmI implements BeanNameAware {

    public void setBeanName(String name) {
        System.out.println("My name is " + name);
    }

}
