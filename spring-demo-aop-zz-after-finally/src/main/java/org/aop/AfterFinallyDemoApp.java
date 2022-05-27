package org.aop;

import org.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = null;
		try {
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch (Exception e) {
			System.out.println("\n\nmain() : Exception in findAccounts()" + e);
		}


		System.out.println("\n\nMain Program: AfterReturningDemoApp.main()");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");

		// close the context
		context.close();
	}

}










