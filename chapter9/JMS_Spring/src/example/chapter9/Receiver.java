package example.chapter9;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Receiver implements MessageListener {

    public void onMessage(Message message) {
        if(message instanceof TextMessage) {
            TextMessage text = (TextMessage) message;
            try {
                System.out.println("Receive: " + text.getText());
            }
            catch(JMSException e) {}
        }
    }
}
