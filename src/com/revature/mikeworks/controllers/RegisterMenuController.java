package com.revature.mikeworks.controllers;

import com.revature.mikeworks.components.RegisterMenu;
import com.revature.mikeworks.utils.ValidScanner;

public class RegisterMenuController {
    private static final RegisterMenu rm = new RegisterMenu();
    private static final ValidScanner scan = new ValidScanner();

    public int readOption() {
        int input = 0;
        do {
            rm.showMenu();
            System.out.println("Input your choice");
            input = scan.readInt();
        } while (input < 1 || input > 7);

        return input;
    }
}
