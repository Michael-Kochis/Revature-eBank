package com.revature.mikeworks.components;

public class BankAccountMenu extends BankMenuAuth {
    public BankAccountMenu() {
        this.addMenuItem(0, "Return to previous menu");
        this.addMenuItem(1, "List your accounts");
        this.addMenuItem(2, "Apply for new account");
        this.addMenuItem(3, "Transactions on existing account");
    }
}
