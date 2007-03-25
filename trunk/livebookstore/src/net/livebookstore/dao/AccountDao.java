package net.livebookstore.dao;

import java.util.List;

import net.livebookstore.domain.*;

/**
 * Define Account operations.
 * 
 * @author xuefeng
 */
public interface AccountDao extends GenericDao<Account> {

    /**
     * Query Account's username, password and privilege.
     * 
     * @param username
     * @return Account object with username, password and privilege.
     */
    Account queryUserDetails(String username);

    /**
     * Change user's password.
     * 
     * @param username Specified username.
     * @param oldPassword Old password.
     * @param newPassword New password.
     */
    void changePassword(String username, String oldPassword, String newPassword);

    /**
     * Query all accounts.
     * 
     * @param page Page info.
     * @param asc Order by asc or desc.
     * @return List of accounts.
     */
    List<Account> query(Page page, boolean asc);
}
