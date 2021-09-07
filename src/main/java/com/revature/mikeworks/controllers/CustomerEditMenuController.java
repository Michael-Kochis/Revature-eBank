package com.revature.mikeworks.controllers;

import com.revature.mikeworks.components.CentralMenu;
import com.revature.mikeworks.components.CustomerEditMenu;
import com.revature.mikeworks.enums.BankSecurity;
import com.revature.mikeworks.utils.ValidScanner;

public class CustomerEditMenuController {
    private static final CustomerEditMenu cem = new CustomerEditMenu();
    private static ValidScanner scan = new ValidScanner();

    public int readOption(BankSecurity auth) {
        int input = 0;
        do {
            cem.showMenu(auth);
            System.out.println("Input your choice");
            input = scan.readInt();
        } while (input < 0 || input > 9);

        return input;
    }
}
