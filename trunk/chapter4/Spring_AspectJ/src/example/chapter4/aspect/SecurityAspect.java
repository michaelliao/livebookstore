package example.chapter4.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SecurityAspect {

    @Around("execution(* example.chapter4.UserService.login(..))")
    public Object securityCheck(ProceedingJoinPoint pjp) throws Throwable {
        String username = (String)pjp.getArgs()[0];
        System.out.println("[security check] username = " + username);
        if(!"admin".equals(username))
            return pjp.proceed();
        System.out.println("[security check] admin is forbidden!");
        throw new RuntimeException("Forbidden");
    }
}
