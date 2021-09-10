package com.revature.mikeworks.controllers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.components.CustomerDirectoryMenu;
import com.revature.mikeworks.enums.BankSecurity;
import com.revature.mikeworks.handlers.CustomerHandler;
import com.revature.mikeworks.utils.ValidScanner;

public class CustomerDirectoryMenuController {
    private static final CustomerDirectoryMenu cdm = new CustomerDirectoryMenu();
    private static final CustomerHandler cHandler = BankData.getCHandler();
    private static ValidScanner scan = new ValidScanner();
    private BankSecurity auth;

    public int readOption() {
        int input = 0;
        auth = BankData.getWhoAmI().getSecurity();
        do {
            cHandler.showAll();
            cdm.showMenu(auth);
            System.out.println("Input your choice");
            input = scan.readInt();
        } while (input < 0 || input > 5);

        return input;
    }
}
