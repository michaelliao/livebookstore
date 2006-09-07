package com.crackj2ee.bookstore.dao.hibernate;

import java.util.List;

import com.crackj2ee.bookstore.dao.AccountDao;
import com.crackj2ee.bookstore.domain.Account;
import com.crackj2ee.bookstore.domain.Page;

/**
 * Implementation of AccountDao.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="accountDao"
 */
public class AccountDaoImpl extends GenericHibernateDaoSupportImpl<Account> implements AccountDao {

    public AccountDaoImpl() {
        super(Account.class);
    }

    public Account login(final String username, final String password) {
        return (Account) queryForObject("from Account as a where a.username=? and a.password=?",
                                        new Object[] {username, password});
    }

    public List<Account> query(Page page) {
        return queryForList("select count(*) from Account as a",
                            "from Account as a order by a.createdDate",
                            null, page);
    }
}
