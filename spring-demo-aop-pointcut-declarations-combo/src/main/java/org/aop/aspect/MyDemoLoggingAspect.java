package org.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* org.aop.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* org.aop.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* org.aop.dao.*.set*(..))")
    private void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageGetterSetter() {}

    @Before("forDaoPackageGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("Before forDaoPackageNoGetterSetter()");
    }

    @Before("forDaoPackageGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("Before performApiAnalytics()");
    }
}
