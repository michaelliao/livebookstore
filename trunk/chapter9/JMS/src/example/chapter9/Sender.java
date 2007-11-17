package example.chapter9;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Sender extends Thread {

    public void run() {
        try {
            Context ctx = new InitialContext();
            ConnectionFactory factory = (ConnectionFactory) ctx.lookup("QueueConnectionFactory");
            Destination destination = (Destination) ctx.lookup("jms/queue");
            for(;;) {
                Connection connection = null;
                try {
                    connection = factory.createConnection();
                    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                    MessageProducer producer = session.createProducer(destination);
                    String text = "Hello, it is " + new Date();
                    System.out.println("   Send: " + text);
                    Message message = session.createTextMessage(text);
                    producer.send(message);
                    producer.close();
                    session.close();
                }
                finally {
                    if(connection!=null)
                        connection.close();
                }
                Thread.sleep(1000 + (long)(Math.random() * 5000));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
