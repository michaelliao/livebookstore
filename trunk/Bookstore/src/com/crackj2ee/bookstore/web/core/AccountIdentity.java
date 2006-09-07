package com.crackj2ee.bookstore.web.core;

import com.crackj2ee.bookstore.domain.Account;

/**
 * Implementation of Identity.
 * 
 * @author xuefeng
 */
public class AccountIdentity implements Identity {

    private String username;
    private boolean isAdmin;

    public AccountIdentity(Account account) {
        this.username = account.getUsername();
        this.isAdmin = account.getPrivilege()==Account.PRIVILEGE_ADMIN;
    }

    /**
     * Get user's display name.
     */
    public String getUsername() { return username; }

    /**
     * Get if current user has admin-role.
     */
    public boolean isAdmin() { return isAdmin; }

}
