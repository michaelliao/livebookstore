package example.chapter9;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;

public class HelloNotificationListener implements NotificationListener, NotificationFilter {

    public void handleNotification(Notification notification, Object handback) {
        AttributeChangeNotification acn = (AttributeChangeNotification)notification;
        System.out.println("Attribute " + acn.getAttributeName()
                + " changed: " + acn.getOldValue() 
                + " -> " + acn.getNewValue());
    }

    public boolean isNotificationEnabled(Notification notification) {
        return (notification instanceof AttributeChangeNotification);
    }

}
