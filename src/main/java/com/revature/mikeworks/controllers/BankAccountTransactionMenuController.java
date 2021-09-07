package com.revature.mikeworks.controllers;

import com.revature.mikeworks.components.BankAccountTransactionMenu;
import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.components.CentralMenu;
import com.revature.mikeworks.enums.BankSecurity;
import com.revature.mikeworks.handlers.BankAccountHandler;
import com.revature.mikeworks.utils.ValidScanner;

public class BankAccountTransactionMenuController {
    private static final BankAccountTransactionMenu bat = new BankAccountTransactionMenu();
    private static final BankAccountHandler baHandler = BankData.getBaHandler();
    private static ValidScanner scan = new ValidScanner();

    public int readOption(BankSecurity auth) {
        int input = 0;
        do {
            if (BankSecurity.authEqualOrGreater(BankSecurity.ADMIN, BankData.getWhoAmI().getSecurity())) {
                baHandler.showAll();
            } else {
                baHandler.showMyAccounts();
            }
            bat.showMenu(auth);
            System.out.println("Input your choice");
            input = scan.readInt();
        } while (input < 0 || input > 5);

        return input;
    }
}
