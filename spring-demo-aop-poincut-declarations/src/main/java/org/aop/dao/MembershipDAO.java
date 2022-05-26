package org.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + "Adding Membership");
    }

    public void goToSleep() {
        System.out.println(getClass() + "Going to sleep");
    }
}
