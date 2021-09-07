package com.revature.mikeworks.components;

public class BankAccountApplyMenu extends BankMenuAuth {
    public BankAccountApplyMenu() {
        this.addMenuItem(0, "Return to Last Menu");
        this.addMenuItem(1, "Change checking/savings");
        this.addMenuItem(2, "Joint account: add member");
        this.addMenuItem(3, "Joint account: remove member");
        this.addMenuItem(4, "Submit Account Application");
    }
}
