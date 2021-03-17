package world.keyi.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
@Order(0)
public class MyAspect {

    public MyAspect() {
        System.out.println("MyAspect已创建");
    }

    @Pointcut("execution(public * world.keyi.service.UserService.*(..))")
    public void log(){}

    @Before("log()")
    public void before(){
        System.out.println("前置通知");
    }

    @After("log()")
    public void after(){
        System.out.println("after方法。。。。。。");
    }

    @AfterThrowing(value = "log()",throwing = "e")
    public void afterThrowing(Throwable e){
        /*
            throwing属性表示使用该参数接收业务逻辑方法抛出的异常对象
         */
        e.printStackTrace();
        System.out.println("只有被增强方法发生异常时，我才会现身");
    }

    @AfterReturning(value = "log()",returning = "result")
    public void afterReturning(Object result){
        /*
            returning属性表示使用该参数接收业务逻辑方法的返回值
         */
        System.out.println("这里是afterReturning方法。。。。。。。");
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        /*
            注意当JoinPoint参数和获取返回值的参数或者其他参数一起使用时，JoinPoint参数必须放在通知方法的参数列表前面
            JoinPoint参数可以用来获取被代理方法的信息，joinPoint.getSignature().getName()获取被代理方法的方法名

            环绕通知
            ProceedingJoinPoint是JoinPoint子接口，表示可以执行目标方法
                1，必须返回Object类型值
                2，必须接收一个参数，类型为ProceedingJoinPoint
                3,必须throws Throwable
         */

        System.out.println("around方法之前。。。。。。。");
        //代表实际方法被执行
        Object result = joinPoint.proceed();
        System.out.println("around方法之后。。。。。。。");
        return result;
    }

}
