package com.revature.mikeworks.components;

import com.revature.mikeworks.enums.BankSecurity;

public class Admin extends Employee {
    public Admin() {
        super();
        this.setSecurity(BankSecurity.ADMIN);
    }
}
