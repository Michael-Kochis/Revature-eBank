package com.revature.mikeworks.controllers;

import com.revature.mikeworks.components.BankAccount;
import com.revature.mikeworks.components.BankAccountApplyMenu;
import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.enums.BankSecurity;
import com.revature.mikeworks.handlers.BankAccountHandler;
import com.revature.mikeworks.utils.ValidScanner;

public class BankAccountApplyMenuController {
    private static final BankAccountApplyMenu baam = new BankAccountApplyMenu();
    private static ValidScanner scan = new ValidScanner();

    public int readOption() {
        BankSecurity auth = BankData.getWhoAmI().getSecurity();
        int input = 0;
        do {
            baam.showMenu(auth);
            System.out.println("Input your choice");
            input = scan.readInt();
        } while (input < 0 || input > 4);

        return input;
    }
}
