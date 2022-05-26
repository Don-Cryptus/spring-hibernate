package org.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(* org.aop.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("Before addAccount()");
    }


}
