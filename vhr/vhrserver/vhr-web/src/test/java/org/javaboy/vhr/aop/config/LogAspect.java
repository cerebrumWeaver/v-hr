package org.javaboy.vhr.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* org.javaboy.vhr.aop.service.*.*(..))")
    public void pc(){

    }
    @Before(value = "pc()")
    public void before(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name+"方法开始执行。。。");
    }
    @After(value = "pc()")
    public void after(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name+"方法执行结束。。。");
    }
    @AfterReturning(value = "pc()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result){
        String name = jp.getSignature().getName();
        System.out.println(name+"方法返回值为："+result);
    }
    @AfterThrowing(value = "pc()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e){
        String name = jp.getSignature().getName();
        System.out.println(name+"方法抛异常了，异常时："+e.getMessage());
    }
    @Around(value = "pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }
}
