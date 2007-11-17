package example.chapter9;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationListener;

public class HelloNotificationListener implements NotificationListener {

    public void handleNotification(Notification notification, Object handback) {
        if(notification instanceof AttributeChangeNotification) {
            AttributeChangeNotification acn = (AttributeChangeNotification)notification;
            System.out.println("Attribute " + acn.getAttributeName()
                    + " changed: " + acn.getOldValue() 
                    + " -> " + acn.getNewValue());
        }
    }

}
