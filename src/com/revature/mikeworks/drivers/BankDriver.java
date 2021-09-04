package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.LoginRegisterMenu;
import com.revature.mikeworks.utils.ValidScanner;

public class BankDriver {
    private static LoginRegisterMenu lr = new LoginRegisterMenu();
    private static ValidScanner scan = new ValidScanner();

    public static void runMain() {
        int input = 0;
        do {
            lr.showMenu();
            System.out.println("Input your choice");
            input = scan.readInt();
        } while (input < 1 || input > 3);
    }
}
