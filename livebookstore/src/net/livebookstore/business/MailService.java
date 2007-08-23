package net.livebookstore.business;

import java.util.List;

import org.acegisecurity.annotation.Secured;

import net.livebookstore.domain.Account;
import net.livebookstore.domain.Order;

/**
 * Create and send mails.
 * 
 * @author Xuefeng
 */
public interface MailService {

    /**
     * Send a registration mail to specified account.
     * 
     * @param account Account who wants to receive this mail.
     */
    void sendRegistrationMail(Account account);

    /**
     * Send a broadcast mail to specified accounts. Each account will 
     * get a copy of broadcast mail.
     */
    @Secured({"ROLE_ADMIN"})
    void sendBroadcastMail(List<Account> accounts, String subject, String text);

    /**
     * Send an order notification mail to specified account.
     */
    @Secured({"ROLE_USER"})
    void sendOrderMail(Order order);

}
