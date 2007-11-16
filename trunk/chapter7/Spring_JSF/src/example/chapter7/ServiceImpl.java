package example.chapter7;

public class ServiceImpl implements Service {

    public void subscribe(SubscriberBean subscriber) {
        System.out.println("User \"" + subscriber.getName()
                + "\" with email \"" + subscriber.getEmail()
                + "\" subscribed successfully with preferred language "
                + subscriber.getLanguage());
    }

}
