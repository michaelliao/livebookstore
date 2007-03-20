package net.livebookstore.mail;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Message listener to handle mail ObjectMesage. When ObjectMessage 
 * is arrived, this class will send mail using pre-defined MailSender 
 * object.
 * 
 * @author Xuefeng
 * 
 * @spring.bean id="mailListener"
 */
public class MailListener implements MessageListener {

    private Log logger = LogFactory.getLog(getClass());

    private MailSender mailSender;

    /**
     * MailSender object is defined in spring-bean.xml.
     * 
     * @spring.property ref="mailSender"
     */
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void onMessage(Message message) {
        if(message instanceof ObjectMessage) {
            try {
                Object object = ((ObjectMessage)message).getObject();
                if(object instanceof SimpleMailMessage) {
                    // send this mail:
                    SimpleMailMessage mail = (SimpleMailMessage)object;
                    logger.info("Sending mail to: " + mail.getTo()[0]);
                    logger.info("Subject: " + mail.getSubject());
                    logger.info("Text: " + mail.getText());
                    mailSender.send(mail);
                }
            }
            catch (JMSException e) {
                logger.warn("Send mail failed.", e);
            }
        }
    }

}
