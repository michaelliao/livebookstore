package net.livebookstore.raw.jms;

import javax.jms.*;
import javax.mail.MessagingException;
import javax.naming.InitialContext;

import org.apache.commons.logging.*;
import org.springframework.mail.SimpleMailMessage;

import net.livebookstore.raw.mail.MailSender;

/**
 * Implementation of MessageListener. A demonstration of handle messages using 
 * JMS directly, not used.
 * 
 * @author xuefeng
 * 
 * #spring.bean id="rawMessageListener" destroy-method="shutdown"
 * 
 * @deprecated
 */
public class MailListener implements MessageListener {

    private Log log = LogFactory.getLog(getClass());

    private MailSender mailSender;
    private ConnectionFactory factory;
    private Connection connection;
    private Queue queue;

    /**
     * spring.constructor-arg value="java:comp/env/jms/factory"
     * spring.constructor-arg value="java:comp/env/jms/queue"
     * spring.constructor-arg ref="mailSender"
     */
    public MailListener(String jndiFactory, String jndiQueue, MailSender mailSender) {
        log.info("Init MessageReceiver...");
        this.mailSender = mailSender;
        try {
            InitialContext ctx = new InitialContext();
            factory = (ConnectionFactory)ctx.lookup(jndiFactory);
            queue = (Queue)ctx.lookup(jndiQueue);
            connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(queue);
            consumer.setMessageListener(this);
            connection.start();
            log.info("Init MessageReceiver successfully!");
        }
        catch(Exception e) {
            log.info("Init MessageReceiver failed.", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public void shutdown() {
        log.info("Shutdown MessageReceiver...");
        try {
            if(connection!=null)
                connection.stop();
        }
        catch(Exception e) {
            log.warn("Error when stop connetion.", e);
        }
    }

    /**
     * Handle message.
     */
    public void onMessage(Message message) {
        log.info("Got jms message.");
        if(!(message instanceof ObjectMessage)) {
            log.info("Message is not ObjectMessage, ignore it.");
            return;
        }
        try {
            SimpleMailMessage mail = (SimpleMailMessage)((ObjectMessage)message).getObject();
            mailSender.send(mail.getFrom(), mail.getTo(), mail.getSubject(), mail.getText());
        }
        catch(JMSException jmse) {
            log.warn(jmse);
        }
        catch (MessagingException me) {
            log.warn("Send mail failed.", me);
        }
    }

}
