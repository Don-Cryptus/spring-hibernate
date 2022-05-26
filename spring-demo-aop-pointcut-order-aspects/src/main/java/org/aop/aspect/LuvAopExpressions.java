package org.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* org.aop.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* org.aop.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* org.aop.dao.*.set*(..))")
    private void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageGetterSetter() {}
}
