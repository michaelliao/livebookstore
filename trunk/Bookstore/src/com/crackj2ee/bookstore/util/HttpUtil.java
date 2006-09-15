package com.crackj2ee.bookstore.util;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.*;

import org.apache.commons.logging.*;

import com.crackj2ee.bookstore.web.core.*;

public final class HttpUtil {

    private static final Log log = LogFactory.getLog(HttpUtil.class);

    public static ThreadLocal<Identity> identityThreadLocal = new ThreadLocal<Identity>();

    private static final String FLAG_FIRST_VISIT = "fl_1stVisit";
    public static final String SESSION_IDENTITY = "identity";

    public static final Cookie CLEAR_USERNAME;

    static {
        // cookie used to clear username & password:
        CLEAR_USERNAME = new Cookie("username", "any");
        CLEAR_USERNAME.setPath("/");
        CLEAR_USERNAME.setMaxAge(0);
    }

    public static Identity getIdentity() {
        return identityThreadLocal.get();
    }

    public static Identity getIdentityFromSession(HttpSession session) {
        return (Identity)session.getAttribute(SESSION_IDENTITY);
    }

    public static void bindIdentityToThreadLocal(Identity identity) {
        identityThreadLocal.set(identity);
    }

    public static String[] getUsernameAndPasswordByCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            String username = null;
            String password = null;
            for(Cookie c : cookies) {
                if(c.getName().equals("username"))
                    username = c.getValue();
                if(c.getName().equals("password"))
                    password = c.getValue();
            }
            if(username!=null && password!=null) {
                return new String[] {username, password};
            }
        }
        return null;
    }

    public static void bindIdentityToSession(HttpSession session, Identity identity) {
        session.setAttribute(SESSION_IDENTITY, identity);
    }

    public static void unbindIdentityFromSession(HttpSession session) {
        session.removeAttribute(SESSION_IDENTITY);
        session.removeAttribute(FLAG_FIRST_VISIT);
    }

    /**
     * Get Integer parameter from request. If specified parameter name 
     * is not found, the default value will be returned.
     */
    public static int getInt(HttpServletRequest request, String paramName, int defaultValue) {
        String s = request.getParameter(paramName);
        if(s==null || s.equals(""))
            return defaultValue;
        return Integer.parseInt(s);
    }

    /**
     * Get Integer parameter from request. If specified parameter name 
     * is not found, an Exception will be thrown.
     */
    public static int getInt(HttpServletRequest request, String paramName) {
        String s = request.getParameter(paramName);
        return Integer.parseInt(s);
    }

    /**
     * Get String parameter from request. If specified parameter name 
     * is not found, the default value will be returned.
     */
    public static String getString(HttpServletRequest request, String paramName, String defaultValue) {
        String s = request.getParameter(paramName);
        if(s==null || s.equals(""))
            return defaultValue;
        return s;
    }

    /**
     * Get String parameter from request. If specified parameter name 
     * is not found or empty, an Exception will be thrown.
     */
    public static String getString(HttpServletRequest request, String paramName) {
        String s = request.getParameter(paramName);
        if(s==null || s.equals(""))
            throw new NullPointerException("Null parameter: " + paramName);
        return s;
    }

    /**
     * Get Boolean parameter from request. If specified parameter name 
     * is not found, an Exception will be thrown.
     */
    public static boolean getBoolean(HttpServletRequest request, String paramName) {
        String s = request.getParameter(paramName);
        return Boolean.parseBoolean(s);
    }

    /**
     * Get Boolean parameter from request. If specified parameter name 
     * is not found, the default value will be returned.
     */
    public static boolean getBoolean(HttpServletRequest request, String paramName, boolean defaultValue) {
        String s = request.getParameter(paramName);
        if(s==null || s.equals(""))
            return defaultValue;
        return Boolean.parseBoolean(s);
    }

    /**
     * Get float parameter from request. If specified parameter name 
     * is not found, an Exception will be thrown.
     */
    public static float getFloat(HttpServletRequest request, String paramName) {
        String s = request.getParameter(paramName);
        return Float.parseFloat(s);
    }

    /**
     * Create a FormBean and bind data to it. Example: If found a parameter named "age", 
     * the object's setAge() method will be invoked if this method exists. 
     * If a setXxx() method exists but no corrsponding parameter, this setXxx() 
     * method will never be invoked.<br/>
     * <b>NOTE:</b> only public setXxx() method can be invoked successfully.
     */
    public static Object createFormBean(HttpServletRequest request, Class c) {
        Object bean;
        try {
            bean = c.newInstance();
        }
        catch (Exception e) {
            return new Object();
        }
        Method[] ms = c.getMethods();
        for(int i=0; i<ms.length; i++) {
            String name = ms[i].getName();
            if(name.startsWith("set")) {
                Class[] cc = ms[i].getParameterTypes();
                if(cc.length==1) {
                    String type = cc[0].getName(); // parameter type
                    try {
                        // get property name:
                        String prop = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                        // get parameter value:
                        String param = getString(request, prop);
                        if(param!=null && !param.equals("")) {
                            if(type.equals("java.lang.String")) {
                                ms[i].invoke(bean, new Object[] {param});
                            }
                            else if(type.equals("int") || type.equals("java.lang.Integer")) {
                                ms[i].invoke(bean, new Object[] {new Integer(param)});
                            }
                            else if(type.equals("long") || type.equals("java.lang.Long")) {
                                ms[i].invoke(bean, new Object[] {new Long(param)});
                            }
                            else if(type.equals("boolean") || type.equals("java.lang.Boolean")) {
                                ms[i].invoke(bean, new Object[] { Boolean.valueOf(param) });
                            }
                            else if(type.equals("float") || type.equals("java.lang.Float")) {
                                ms[i].invoke(bean, new Object[] {new Float(param)});
                            }
                            else if(type.equals("java.util.Date")) {
                                Date date = null;
                                if(param.indexOf(':')!=(-1))
                                    date = DateUtil.parseDateTime(param);
                                else
                                    date = DateUtil.parseDate(param);
                                if(date!=null)
                                    ms[i].invoke(bean, new Object[] {date});
                                else
                                    System.err.println("WARNING: date is null: " + param);
                            }
                        }
                    }
                    catch(Exception e) {
                        System.err.println("WARNING: Invoke method " + ms[i].getName() + " failed: " + e.getMessage());
                    }
                }
            }
        }
        return bean;
    }

}
