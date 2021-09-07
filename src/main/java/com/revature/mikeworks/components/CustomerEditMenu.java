package com.revature.mikeworks.components;

import com.revature.mikeworks.enums.BankSecurity;

public class CustomerEditMenu extends BankMenuAuth {
    public CustomerEditMenu() {
        this.addMenuItem(0, "Return to previous menu");
        this.addMenuItem(1, "List all customers", BankSecurity.ADMIN);
        this.addMenuItem(2, "Change customer being edited", BankSecurity.ADMIN);
        this.addMenuItem(3, "Change username", BankSecurity.ADMIN);
        this.addMenuItem(4, "Set new password", BankSecurity.ADMIN);
        this.addMenuItem(5, "Set new first name", BankSecurity.ADMIN);
        this.addMenuItem(6, "Set new last name", BankSecurity.ADMIN);
        this.addMenuItem(7, "Set new email", BankSecurity.ADMIN);
        this.addMenuItem(8, "Set as Employee", BankSecurity.ADMIN);
        this.addMenuItem(9, "Set as fellow Admin", BankSecurity.ADMIN);
    }
}
