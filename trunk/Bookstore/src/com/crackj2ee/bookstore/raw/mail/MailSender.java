package com.crackj2ee.bookstore.raw.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This demo shows how to send mail directly using JavaMail API.
 * 
 * @author Xuefeng
 * 
 * @deprecated
 */
public class MailSender {

    private Log log = LogFactory.getLog(getClass());

    private static final String SMTP_AUTH = "mail.smtp.auth";

    private String protocol = "smtp";
    private String host;
    private int port = 25;
    private String username;
    private String password;
    private Properties props = new Properties();

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuth(boolean auth) {
        props.setProperty(SMTP_AUTH, String.valueOf(auth));
    }

    public void send(String from, String[] to, String subject, String text) throws MessagingException {
        Session session = Session.getInstance(props);
        Transport transport = null;
        try {
            transport = session.getTransport(protocol);
            transport.connect(host, port, username, password);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);
            message.setSentDate(new Date());
            Address[] addressTo = new Address[to.length];
            for(int i=0; i<to.length; i++) {
                addressTo[i] = new InternetAddress(to[i]);
            }
            message.setRecipients(Message.RecipientType.TO, addressTo);
            message.saveChanges();
            log.debug("Try to send message...");
            transport.sendMessage(message, addressTo);
            log.debug("Sent message done.");
        }
        finally {
            if(transport!=null) {
                transport.close();
            }
        }
    }

}
