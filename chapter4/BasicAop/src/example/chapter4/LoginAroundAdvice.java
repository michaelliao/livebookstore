package example.chapter4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoginAroundAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        if(args[0].equals("admin"))
            throw new SecurityException("Rejected");
        return invocation.proceed();
    }

}
