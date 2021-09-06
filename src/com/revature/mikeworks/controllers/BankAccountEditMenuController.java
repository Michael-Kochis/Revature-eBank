package com.revature.mikeworks.controllers;

import com.revature.mikeworks.components.AccountEditMenu;
import com.revature.mikeworks.components.CentralMenu;
import com.revature.mikeworks.enums.BankSecurity;
import com.revature.mikeworks.utils.ValidScanner;

public class BankAccountEditMenuController {
    private static final AccountEditMenu aem = new AccountEditMenu();
    private static ValidScanner scan = new ValidScanner();

    public int readOption(BankSecurity auth) {
        int input = 0;
        do {
            aem.showMenu(auth);
            System.out.println("Input your choice");
            input = scan.readInt();
        } while (input < 0 || input > 6);

        return input;
    }
}
