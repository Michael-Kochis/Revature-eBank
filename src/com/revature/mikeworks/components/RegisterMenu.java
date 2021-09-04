package com.revature.mikeworks.components;

public class RegisterMenu extends BankMenu{
    public RegisterMenu() {
        this.addMenuItem(1, "New Username");
        this.addMenuItem(2, "Change Password");
        this.addMenuItem(3, "Set First Name");
        this.addMenuItem(4, "Set Last Name");
        this.addMenuItem(5, "Set Email");
        this.addMenuItem(6, "Register this user");
        this.addMenuItem(7 , "Abort: Return to Main menu");
    }

    @Override
    public void showMenu() {
        super.showMenu();
    }
}
