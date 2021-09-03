package com.revature.mikeworks.components;

import com.revature.mikeworks.enums.BankSecurity;

public class Employee extends Customer{
    public Employee() {
        super();
        this.setSecurity(BankSecurity.EMPLOYEE);
    }
}
