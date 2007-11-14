package example.chapter3;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * A message-publisher bean.
 * 
 * @author Xuefeng
 */
public class MessagePublisher implements ApplicationContextAware, ApplicationListener {

    private ApplicationContext context;

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    public void sendMessage(final String message) {
        context.publishEvent(
            new ApplicationEvent(this) {
                public String toString() {
                    return message;
                }
            }
        );
    }

    public void onApplicationEvent(ApplicationEvent event) {
        if(this==event.getSource())
            System.out.println("Ignore event because it was published by myself.");
    }
}
