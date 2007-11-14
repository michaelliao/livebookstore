package example.chapter4;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * Before a method call.
 * 
 * @author Xuefeng
 */
public class LoginMethodBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method m, Object[] args, Object target) throws Throwable {
        System.out.println("[LoginMethodBeforeAdvice] User " + args[0] + " try to login...");
    }
}
