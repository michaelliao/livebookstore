package com.crackj2ee.bookstore.dao;

import java.util.List;

import com.crackj2ee.bookstore.domain.*;

/**
 * Define Account operation.
 * 
 * @author xuefeng
 */
public interface AccountDao extends GenericDaoSupport<Account> {

    /**
     * Do login.
     * 
     * @param username
     * @param password
     * @return Account object with specified username.
     */
    Account login(String username, String password);

    /**
     * Query all accounts.
     * 
     * @param page Page info.
     * @return List of accounts.
     */
    List<Account> query(Page page);
}
