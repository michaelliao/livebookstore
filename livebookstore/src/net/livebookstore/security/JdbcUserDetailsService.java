package net.livebookstore.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import net.livebookstore.domain.Account;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.User;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;

/**
 * Implementation of UserDetailsService by JDBC. This requires a DataSource 
 * injection only.
 * 
 * @author Xuefeng
 */
public class JdbcUserDetailsService implements UserDetailsService {

    private final Log log = LogFactory.getLog(getClass());

    private final GrantedAuthority ROLE_ADMIN = new GrantedAuthorityImpl("ROLE_ADMIN");
    private final GrantedAuthority ROLE_USER = new GrantedAuthorityImpl("ROLE_USER");

    private final GrantedAuthority[] AUTHORITY_ADMIN = new GrantedAuthority[] {ROLE_ADMIN, ROLE_USER};
    private final GrantedAuthority[] AUTHORITY_USER = new GrantedAuthority[] {ROLE_USER};

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        if(log.isDebugEnabled())
            log.debug("Loading UserDetails of username: " + username);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            boolean autoCommit = conn.getAutoCommit();
            conn.setAutoCommit(true);
            ps = conn.prepareStatement("select password as pwd, privilege from t_account where username=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(!rs.next()) {
                log.warn("UserDetails load failed: No such user with username - " + username);
                throw new UsernameNotFoundException("User name is not found.");
            }
            String password = rs.getString(1);
            int privilege = rs.getInt(2);
            if(!conn.getAutoCommit())
                conn.commit();
            log.info("Username " + username + " loaded successfully.");
            conn.setAutoCommit(autoCommit);
            return new User(username, password, true, true, true, true, privilege==Account.PRIVILEGE_ADMIN
                    ? AUTHORITY_ADMIN : AUTHORITY_USER);
        }
        catch(SQLException sqle) {
            log.error("Error retrieving UserDetails from database.", sqle);
            throw new DataRetrievalFailureException("Data retrieval failed.", sqle);
        }
        finally {
            if(rs!=null) {
                try {
                    rs.close();
                }
                catch(SQLException e) {
                    log.warn("Close ResultSet exception.", e);
                }
            }
            if(ps!=null) {
                try {
                    ps.close();
                }
                catch(SQLException e) {
                    log.warn("Close PreparedStatement exception.", e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                }
                catch(SQLException e) {
                    log.warn("Close Connection exception.", e);
                }
            }
        }
    }

}
