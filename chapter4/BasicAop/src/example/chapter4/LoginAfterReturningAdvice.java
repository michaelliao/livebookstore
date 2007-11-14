package example.chapter4;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LoginAfterReturningAdvice implements AfterReturningAdvice {

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("[LoginAfterReturningAdvice] User " + args[0] + " logged in successfully.");
    }

}
