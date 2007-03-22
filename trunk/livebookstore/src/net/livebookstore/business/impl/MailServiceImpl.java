package net.livebookstore.business.impl;

import java.io.*;
import java.util.List;

import javax.jms.*;

import net.livebookstore.domain.Account;
import net.livebookstore.domain.Book;
import net.livebookstore.domain.Order;
import net.livebookstore.domain.OrderItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.mail.SimpleMailMessage;

import net.livebookstore.business.MailService;

/**
 * Implementation of MailService.
 * 
 * @author Xuefeng
 * 
 * @spring.bean id="mailService"
 */
public class MailServiceImpl implements MailService {

    private final Log log = LogFactory.getLog(getClass());

    private static final String ACCOUNT_USERNAME = "\\$\\{USERNAME\\}";

    private String from;
    private String signature;

    private final String registration_subject = "恭喜您成功注册成为Live在线书店的会员！";
    private final String registration_body;
    private final String order_subject = "订单通知：您在Live在线书店的订单";
    private final String order_body;

    private JmsTemplate jmsTemplate;
    private Destination destination;

    public MailServiceImpl() {
        // load templates:
        String packagePath = getClass().getPackage().getName().replace('.', '/') + "/";
        this.signature = loadTemplate(packagePath + "signature.txt");
        this.registration_body = loadTemplate(packagePath + "registration.txt");
        this.order_body = loadTemplate(packagePath + "order.txt");
    }

    /**
     * @spring.property ref="jmsConnectionFactory"
     */
    public void setConnectionFactory(ConnectionFactory cf) {
        this.jmsTemplate = new JmsTemplate(cf);
    }

    /**
     * @spring.property ref="jmsDestination"
     */
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    protected void sendMessage(final SimpleMailMessage message) {
        log.info("try to send message to " + message.getTo()[0]);
        this.jmsTemplate.send(this.destination,
                new MessageCreator() {
                    public Message createMessage(Session session) throws JMSException {
                        return session.createObjectMessage(message);
                    }
                }
        );
    }

    /**
     * Set admin's email address, which is displayed in mail-sender.
     * 
     * @spring.property value="service@crackj2ee.com"
     */
    public void setFrom(String from) {
        this.from = from;
    }

    public void sendBroadcastMail(List<Account> accounts, String subject, String text) {
        for(Account account : accounts) {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom(from);
            mail.setTo(account.getEmail());
            mail.setSubject(subject);
            mail.setText(text.replaceAll(ACCOUNT_USERNAME, account.getDisplayName()));
            sendMessage(mail);
        }
    }

    public void sendOrderMail(Order order) {
        Account account = order.getAccount();
        StringBuffer sb = new StringBuffer(1024);
        sb.append("书名                           单价   数量   折扣   价格\n");
        sb.append("----------------------------------------------------------\n");
        List<OrderItem> items = order.getOrderItems();
        float order_total = 0;
        for(OrderItem item : items) {
            Book book = item.getBook();
            sb.append(format(book.getName(), 30)).append(' ');
            sb.append(format(String.valueOf(book.getPrice()), 6)).append(' ');
            sb.append(format(String.valueOf(item.getNumber()), 6)).append(' ');
            sb.append(format(book.getDiscountAsString(), 6)).append(' ');
            float item_total = book.getPrice() * item.getNumber() * book.getDiscount() / 100f;
            order_total += item_total;
            sb.append(format(String.valueOf(item_total), 6)).append(' ');
        }
        sb.append("----------------------------------------------------------\n");
        sb.append("合计应付金额：").append(order_total).append('\n');

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(from);
        mail.setTo(account.getEmail());
        mail.setSubject(order_subject);
        mail.setText(
                (this.order_body + signature).replaceAll(ACCOUNT_USERNAME, account.getDisplayName())
                .replaceAll("\\$\\{ORDER_DATE\\}", order.getCreatedDate().toString())
                .replaceAll("\\$\\{ORDER_ID\\}", order.getId().toString())
                .replaceAll("\\$\\{ORDER_DETAIL\\}", sb.toString())
        );
        sendMessage(mail);
    }

    public void sendRegistrationMail(Account account) {
        String text = registration_body + signature;
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(from);
        mail.setTo(account.getEmail());
        mail.setSubject(registration_subject);
        mail.setText(text.replaceAll(ACCOUNT_USERNAME, account.getDisplayName()));
        sendMessage(mail);
    }

    private String loadTemplate(String templateName) {
        Resource resource = new ClassPathResource(templateName);
        try {
            File file = resource.getFile();
            BufferedReader reader = null;
            StringBuffer sb = new StringBuffer(1024);
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                for(;;) {
                    String line = reader.readLine();
                    if(line==null)
                        break;
                    sb.append(line).append('\n');
                }
                String template = sb.toString();
                log.info("Load template: " + templateName);
                log.info(template);
                return template;
            }
            finally {
                if(reader!=null)
                    reader.close();
            }
        }
        catch (IOException e) {
            log.info("Load template failed.", e);
        }
        return "(Empty)";
    }

    private String format(String s, int length) {
        char[] cs = s.toCharArray();
        int count = 0;
        for(int i=0; i<cs.length; i++) {
            char c = cs[i];
            if(c<=127)
                count++;
            else
                count+=2;
        }
        int sp = length - count;
        if(sp>0) {
            char[] spaces = new char[sp];
            for(int i=0; i<spaces.length; i++)
                spaces[i] = ' ';
            return s + new String(spaces);
        }
        return s;
    }
}
