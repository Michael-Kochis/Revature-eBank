package com.revature.mikeworks.components;

public class CustomerDirectoryMenu extends BankMenuAuth {
    public CustomerDirectoryMenu() {
        this.addMenuItem(0, "Return to last menu");
        this.addMenuItem(1, "List all customers");
    }
}
