package com.crackj2ee.bookstore.dao.jdbc;

import java.io.Serializable;
import java.util.List;

import com.crackj2ee.bookstore.dao.AccountDao;
import com.crackj2ee.bookstore.domain.Account;
import com.crackj2ee.bookstore.domain.Page;

public class AccountDaoImpl extends JdbcDaoSupport<Account> implements AccountDao {

    public Account login(String username, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Account> query(Page page) {
        // TODO Auto-generated method stub
        return null;
    }

    public void create(Account t) {
        // TODO Auto-generated method stub

    }

    public void delete(Account t) {
        // TODO Auto-generated method stub

    }

    public Account query(Serializable id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void update(Account t) {
        // TODO Auto-generated method stub

    }

}
