package org.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {

    @Before("org.aop.aspect.LuvAopExpressions.forDaoPackageGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("Before performApiAnalytics()");
    }
}
