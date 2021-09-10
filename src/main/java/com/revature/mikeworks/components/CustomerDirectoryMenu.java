package com.revature.mikeworks.components;

public class CustomerDirectoryMenu extends BankMenuAuth {
    public CustomerDirectoryMenu() {
        this.addMenuItem(0, "Return to last menu");
        this.addMenuItem(1, "Change username");
        this.addMenuItem(2, "Change password");
        this.addMenuItem(3, "Change first name");
        this.addMenuItem(4, "Change last name");
        this.addMenuItem(5, "Change email");
    }
}
