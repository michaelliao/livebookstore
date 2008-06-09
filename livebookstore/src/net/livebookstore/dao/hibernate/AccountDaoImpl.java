package net.livebookstore.dao.hibernate;

import java.util.List;

import org.acegisecurity.userdetails.UsernameNotFoundException;

import net.livebookstore.domain.Account;
import net.livebookstore.domain.Page;

import net.livebookstore.dao.AccountDao;
import net.livebookstore.exception.ApplicationException;

/**
 * Implementation of AccountDao.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="accountDao"
 */
public class AccountDaoImpl extends GenericHibernateDao<Account> implements AccountDao {

    public AccountDaoImpl() {
        super(Account.class);
    }

    public Account queryUserDetails(String username) {
        Account account = queryForObject(
                "select new Account(a.username, a.password, a.email, a.privilege) from Account as a where a.username=?",
                new Object[] {username}
        );
        if(account!=null)
            return account;
        throw new UsernameNotFoundException("用户名不存在");
    }

    private static final String QUERY_ACCOUNT_ASC = "select new Account(a.username, a.password, a.email, a.privilege, a.createdDate) from Account as a order by a.createdDate";
    private static final String QUERY_ACCOUNT_DESC = "select new Account(a.username, a.password, a.email, a.privilege, a.createdDate) from Account as a order by a.createdDate desc";

    public List<Account> query(Page page, boolean asc) {
        return queryForList(
                "select count(*) from Account as a",
                asc ? QUERY_ACCOUNT_ASC : QUERY_ACCOUNT_DESC,
                null,
                page
        );
    }

    public void changePassword(String username, String oldPassword, String newPassword) {
        if(!oldPassword.matches("[a-f0-9]{32}"))
            throw new ApplicationException("无效的口令");
        if(!newPassword.matches("[a-f0-9]{32}"))
            throw new ApplicationException("无效的口令");
        int rows = executeUpdate(
                "update Account as a set a.password=? where a.username=? and a.password=?",
                new Object[] {newPassword, username, oldPassword});
        if(rows==0)
            throw new ApplicationException("无效的旧口令");
    }
}
