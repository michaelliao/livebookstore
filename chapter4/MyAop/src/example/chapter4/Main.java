package example.chapter4;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class Main {

    public static void main(String[] args) {
        // 创建UserDao和UserService对象并设置依赖注入:
        UserDao userDao = new UserDao();
        UserServiceImpl target = new UserServiceImpl();
        target.setUserDao(userDao);
        // 创建日志记录切面:
        MethodBeforeAdvice log = new MethodBeforeAdvice() {
            public void before(Method m, Object[] args, Object target) throws Throwable {
                System.out.println("call method: " + m.getName());
            }
        };
        // 创建动态代理类:
        UserService userService = (UserService)AopProxyFactory.createProxy(target, log);
        // 调用代理类的方法:
        userService.create("aop", "mypassword");
        userService.login("aop", "mypassword");
        // 检查UserDao中的数据:
        userDao.print();
    }
}
