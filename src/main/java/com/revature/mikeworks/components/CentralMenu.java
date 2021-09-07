package com.revature.mikeworks.components;

import com.revature.mikeworks.enums.BankSecurity;

public class CentralMenu extends BankMenuAuth {
    public CentralMenu() {
        this.addMenuItem(0, "Log out");
        this.addMenuItem(1, "Profile Options");
        this.addMenuItem(2, "Bank Account Options");
        this.addMenuItem(3, "View Customer Information", BankSecurity.EMPLOYEE);
        this.addMenuItem(4, "Approve/Deny Accounts", BankSecurity.EMPLOYEE);
        this.addMenuItem(5, "Edit Profiles", BankSecurity.ADMIN);
        this.addMenuItem(6, "Edit Bank Accounts", BankSecurity.ADMIN);
    }

}
