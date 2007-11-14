package example.chapter4.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggerAspect {

    @Pointcut("execution(* example.chapter4.UserService.login(..))")
    public void loginMethod() {};

    //@Before("execution(* example.chapter4.UserService.login(..))")
    @Before(value="loginMethod()")
    public void logBefore() {
        System.out.println("[logger] User try to login...");
    }

    //@AfterReturning("execution(* example.chapter4.UserService.login(..)) && args(username,..)")
    @AfterReturning("loginMethod() && args(username,..)")
    public void logSuccess(String username) {
        System.out.println("[logger] User " + username + " login successfully!");
    }

    //@AfterThrowing(
    //    pointcut="execution(* example.chapter4.UserService.login(..))",
    //    throwing="e"
    //)
    @AfterThrowing(
        pointcut="loginMethod()",
        throwing="e"
    )
    public void logFailure(RuntimeException e) {
        System.out.println("[logger] Exception: " + e.getMessage());
    }

}
