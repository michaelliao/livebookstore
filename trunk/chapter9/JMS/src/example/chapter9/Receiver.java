package example.chapter9;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Receiver extends Thread implements MessageListener {

    public void run() {
        try {
            Context ctx = new InitialContext();
            ConnectionFactory factory = (ConnectionFactory) ctx.lookup("QueueConnectionFactory");
            Destination destination = (Destination) ctx.lookup("jms/queue");
            Connection connection = null;
            try {
                connection = factory.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageConsumer consumer = session.createConsumer(destination);
                consumer.setMessageListener(this);
                connection.start();
                Thread.sleep(20000);
            }
            finally {
                if(connection!=null)
                    connection.close();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void onMessage(Message message) {
        if(message instanceof TextMessage) {
            TextMessage text = (TextMessage) message;
            try {
                System.out.println("Receive: " + text.getText());
            }
            catch(JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
