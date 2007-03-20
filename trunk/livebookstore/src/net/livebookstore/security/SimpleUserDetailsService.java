package net.livebookstore.security;

import net.livebookstore.business.BusinessService;
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

/**
 * Implementation of UserDetailsService by business service. Need a 
 * BusinessService injection.
 * 
 * @author Xuefeng
 */
public class SimpleUserDetailsService implements UserDetailsService {

    private final Log log = LogFactory.getLog(getClass());

    private final GrantedAuthority ROLE_ADMIN = new GrantedAuthorityImpl("ROLE_ADMIN");
    private final GrantedAuthority ROLE_USER = new GrantedAuthorityImpl("ROLE_USER");

    private final GrantedAuthority[] AUTHORITY_ADMIN = new GrantedAuthority[] {ROLE_ADMIN, ROLE_USER};
    private final GrantedAuthority[] AUTHORITY_USER = new GrantedAuthority[] {ROLE_USER};

    private BusinessService service;

    public void setBusinessService(BusinessService service) {
        this.service = service;
    }

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        if(log.isDebugEnabled())
            log.debug("Loading UserDetails of username: " + username);
        Account account = service.queryUserDetails(username);
        return new User(account.getUsername(), account.getPassword(),
                true, true, true, true,
                account.getPrivilege()==Account.PRIVILEGE_ADMIN ? AUTHORITY_ADMIN : AUTHORITY_USER);
    }

}
