package example.chapter4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.aop.MethodBeforeAdvice;

public class AopProxyFactory {

    public static Object createProxy(final Object target, final MethodBeforeAdvice methodBeforeAdvice) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        methodBeforeAdvice.before(method, args, target);
                        return method.invoke(target, args);
                    }
                });
    }
}
