package example.chapter3;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * A message-listener bean.
 * 
 * @author Xuefeng
 */
public class MessageListener implements ApplicationListener {

    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event.toString());
    }

}
