package org.aop.dao;

import org.aop.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": DOING MY DB WORK");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": FETCHING NAME");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": SETTING NAME");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": FETCHING SERVICE CODE");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": SETTING SERVICE CODE");
        this.serviceCode = serviceCode;
    }
}
