package com.crackj2ee.bookstore.raw.jms;

import javax.jms.*;
import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.SimpleMailMessage;

/**
 * Demo of using JMS to send a message directly.
 * 
 * @author Xuefeng
 * 
 * @deprecated
 */
public class JmsSender {

    private Log log = LogFactory.getLog(getClass());
    private ConnectionFactory factory;
    private Queue queue;

    public JmsSender() {
        log.info("Init JmsSender...");
        try {
            InitialContext ctx = new InitialContext();
            factory = (ConnectionFactory)ctx.lookup("java:comp/env/jms/factory");
            queue = (Queue)ctx.lookup("java:comp/env/jms/queue");
            log.info("Init JmsSender successfully!");
        }
        catch(Exception e) {
            log.info("Init MailService failed.", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public void send(SimpleMailMessage mail) {
        Connection connection = null;
        Session session = null;
        try {
            connection = factory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Message message = session.createObjectMessage(mail);
            MessageProducer producer = session.createProducer(queue);
            producer.send(message);
            producer.close();
            log.info("Send message successfully!");
        }
        catch(JMSException e) {
            log.info("Send message failed.", e);
        }
        finally {
            if(session!=null) {
                try {
                    session.close();
                }
                catch(JMSException e) {
                    log.warn("Exception when close session.", e);
                }
            }
            if(connection!=null) {
                try {
                    connection.close();
                }
                catch(JMSException e) {
                    log.warn("Exception when close session.", e);
                }
            }
        }
    }
}
