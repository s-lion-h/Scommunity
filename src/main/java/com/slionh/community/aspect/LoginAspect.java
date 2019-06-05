package com.slionh.community.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
 * Create by s lion h on 2019/6/5
 */
@Component
@Aspect
public class LoginAspect {
    @Pointcut("execution(* com.slionh.community.controller.UserController.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void userStart(JoinPoint joinPoint){
        System.out.println("info : user "+joinPoint.getSignature().getName()+" start");
    }

    @After("pointcut()")
    public void userAfter(JoinPoint joinPoint){
        System.out.println("info : user "+joinPoint.getSignature().getName()+" end");
    }

    @AfterReturning(value = "pointcut()",returning = "result")
    public void loggingReturn(Object result){
        System.out.println("info : user return {\n"+result.toString()+"\n}");
    }

    @AfterThrowing(value = "pointcut()",throwing = "exception")
    public void logException(Exception exception){
        System.out.println("info : user exception {\n"+exception+"\n}");

    }
}
