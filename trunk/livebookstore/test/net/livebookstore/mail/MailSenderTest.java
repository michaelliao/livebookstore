package net.livebookstore.mail;

import java.util.Properties;

import org.junit.*;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Test configuration of Spring MailSender.
 * 
 * @author Xuefeng
 */
public class MailSenderTest {

    private String from = "service@crackj2ee.com";
    private String to = "livebookstore2@gmail.com";
    private String subject = "Test JavaMailSenderImpl 配置";
    private String text = "Configuration is OK if got this mail. 中文显示正常。";

    @Test(expected=MailSendException.class, timeout=60000)
    public void sendWithoutAuth() {
        JavaMailSender sender = createMailSender(null);
        sender.send(createMessage());
    }

    // if you got a "Software caused connection abort..." exception, 
    // check your firewall or anti-virus software settings.
    @Test(timeout=60000)
    public void sendWithAuth() {
        // add 'auth':
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        JavaMailSender sender = createMailSender(props);
        sender.send(createMessage());
    }

    private JavaMailSender createMailSender(Properties props) {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.crackj2ee.com");
        sender.setUsername("service@crackj2ee.com");
        sender.setPassword("livebookstore");
        sender.setDefaultEncoding("GBK");
        if(props!=null)
            sender.setJavaMailProperties(props);
        return sender;
    }

    private SimpleMailMessage createMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        return message;
    }
}
