package com.revature.mikeworks.controllers;

import com.revature.mikeworks.components.AccountApprovalMenu;
import com.revature.mikeworks.enums.BankSecurity;
import com.revature.mikeworks.utils.ValidScanner;

public class AccountApprovalMenuController {
    private static final AccountApprovalMenu aam = new AccountApprovalMenu();
    private static ValidScanner scan = new ValidScanner();

    public int readOption(BankSecurity auth) {
        int input = 0;
        do {
            aam.showMenu(auth);
            System.out.println("Input your choice");
            input = scan.readInt();
        } while (input < 0 || input > 2);

        return input;
    }
}
