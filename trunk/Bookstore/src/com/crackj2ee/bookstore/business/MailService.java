package com.crackj2ee.bookstore.business;

import java.util.List;

import com.crackj2ee.bookstore.domain.Account;
import com.crackj2ee.bookstore.domain.Order;

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
    void sendBroadcastMail(List<Account> accounts, String subject, String text);

    /**
     * Send an order notification mail to specified account.
     */
    void sendOrderMail(Order order);

}
