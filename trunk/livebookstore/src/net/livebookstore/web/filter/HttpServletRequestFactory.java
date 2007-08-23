package net.livebookstore.web.filter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Create a mock HttpServletRequest object by specified uri and parameters.
 * 
 * @author Xuefeng
 */
public class HttpServletRequestFactory {

    // always proxy HttpServletRequest interface:
    private static final Class[] PROXY_INTERFACES = { HttpServletRequest.class };

    /**
     * To wrap a uri and parameters as an HttpServletRequest object. The 
     * returned object has only HttpServletRequest interface, and only 
     * <code>getRequestURI()</code>, <code>getParameter()</code> can be 
     * invoked. Any other method-call will cause an 
     * <code>UnsupportedOperationException</code>.
     * 
     * @param uri URI of this HttpServletRequest.
     * @param parameters All parameters of this HttpServletRequest.
     * @return Proxy interface of HttpServletRequest object.
     */
    public static HttpServletRequest create(final String uri, final Map<String, String> parameters) {
        return (HttpServletRequest) Proxy.newProxyInstance(
                HttpServletRequestFactory.class.getClassLoader(),
                PROXY_INTERFACES,
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String methodName = method.getName();
                        if(methodName.equals("getRequestURI"))
                            return uri;
                        if(methodName.equals("getParameter"))
                            return parameters.get(args[0]);
                        throw new UnsupportedOperationException("Method " + methodName + " are not supported.");
                    }
                }
        );
    }
}
