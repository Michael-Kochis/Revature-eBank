package com.revature.mikeworks.components;

public class LoginRegisterMenu extends BankMenu {

    public LoginRegisterMenu() {
        this.addMenuItem(1, "Login");
        this.addMenuItem(2, "Register");
        this.addMenuItem(3 , "exit");
    }

    @Override
    public void showMenu() {
        super.showMenu();
    }


}
