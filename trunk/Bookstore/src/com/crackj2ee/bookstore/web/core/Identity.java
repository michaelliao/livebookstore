package com.crackj2ee.bookstore.web.core;

import java.io.Serializable;

/**
 * Identity represent a logged-in user hold in http session.
 * 
 * @author xuefeng
 */
public interface Identity extends Serializable {

    /**
     * User's unique login-name.
     */
    String getUsername();

    /**
     * Is admin-role?
     */
    boolean isAdmin();

}
