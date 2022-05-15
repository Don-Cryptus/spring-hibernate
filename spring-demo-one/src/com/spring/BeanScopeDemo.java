package com.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);
        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());

        boolean result = (theCoach == alphaCoach);

        System.out.println("\n Pointing to the same object: " + result);

        System.out.println("\n Memory location for theCoach: " + theCoach);

        System.out.println("\n Memory location for alphaCoach: " + alphaCoach);

        context.close();
    }
}
