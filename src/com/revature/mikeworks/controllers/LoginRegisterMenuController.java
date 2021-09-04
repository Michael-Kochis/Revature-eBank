package com.revature.mikeworks.controllers;

import com.revature.mikeworks.components.LoginRegisterMenu;
import com.revature.mikeworks.utils.ValidScanner;

public class LoginRegisterMenuController {
    private static final LoginRegisterMenu lr = new LoginRegisterMenu();
    private static ValidScanner scan = new ValidScanner();

    public int readOption() {
        int input = 0;
        do {
            lr.showMenu();
            System.out.println("Input your choice");
            input = scan.readInt();
        } while (input < 1 || input > 3);

        return input;
    }
}
