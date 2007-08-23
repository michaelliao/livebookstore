package net.livebookstore.security;

import org.acegisecurity.AccessDeniedException;
import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.userdetails.UserDetails;

public class SecurityUtil {

    public static String getCurrentUsername() {
        String username = getCurrentUsernameOrNull();
        if(username==null)
            throw new AccessDeniedException("Access denied.");
        return username;
    }

    public static String getCurrentUsernameOrNull() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return _getUsernameFromAuth(auth);
    }

    public static boolean isAdminRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return _hasRole(auth, "ROLE_ADMIN");
    }

    public static void assertUsername(String username) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        _assertUsername(auth, username);
    }

    public static void assertRoleOrUsername(String role, String username) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!_hasRole(auth, role))
            _assertUsername(auth, username);
    }

    private static String _getUsernameFromAuth(Authentication auth) {
        if(auth==null)
            return null;
        if (auth.getPrincipal() instanceof UserDetails) {
            return ((UserDetails) auth.getPrincipal()).getUsername();
        }
        return auth.getPrincipal().toString();
    }

    private static boolean _hasRole(Authentication auth, String role) {
        if(auth==null)
            return false;
        GrantedAuthority[] gas = auth.getAuthorities();
        for(GrantedAuthority ga : gas) {
            if(ga.getAuthority().equals(role))
                return true;
        }
        return false;
    }

    private static void _assertUsername(Authentication auth, String username) {
        String s = _getUsernameFromAuth(auth);
        if(s==null || !s.equals(username))
            throw new AccessDeniedException("Access denied.");
    }
}
