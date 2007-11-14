package example.chapter3;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WhereAmI implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println(context);
    }

}
