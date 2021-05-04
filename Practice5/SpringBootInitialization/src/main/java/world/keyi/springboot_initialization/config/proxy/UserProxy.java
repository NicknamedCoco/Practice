package world.keyi.springboot_initialization.config.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author 万一
 * @date 2021年04月30日13:15
 */

public class UserProxy {
    /*@Pointcut("execution(* world.keyi.springboot_initialization)")
    public void pointCut(){

    }*/

    //@Before("pointCut()")
    public void before(){
        System.out.println("切入点方法之前执行");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("切入点方法之后执行");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("只有被增强方法发生异常时，我才会现身");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning方法。。。。。。。");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around方法之前。。。。。。。");
        joinPoint.proceed();
        System.out.println("around方法之后。。。。。。。");
    }
}
