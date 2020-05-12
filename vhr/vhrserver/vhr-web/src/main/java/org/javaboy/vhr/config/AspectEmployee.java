package org.javaboy.vhr.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @作者 cerebrumWeaver
 * @日期 2020/3/16 9:22
 */
@Component
@Aspect
public class AspectEmployee {
    @Pointcut("execution(* org.javaboy.vhr.controller.emp.EmpBasicController.*(..))")
    public void emp(){}

    @Before(value = "emp()")
    public void before(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name+"方法开始执行-----start-----");
    }

    @After(value = "emp()")
    public void after(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name+"方法执行完毕-----end-------");
    }

    @AfterReturning(value = "emp()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result){
        String name = jp.getSignature().getName();
        System.out.println(name+"方法返回值为："+result.toString());
    }

    @AfterThrowing(value = "emp()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e){
        String name = jp.getSignature().getName();
        System.out.println(name+"方法抛出了异常，异常为："+e.getMessage());
    }

    @Around(value = "emp()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }
}
