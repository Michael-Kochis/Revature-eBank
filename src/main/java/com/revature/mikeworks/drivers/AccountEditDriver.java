package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.controllers.BankAccountEditMenuController;
import com.revature.mikeworks.handlers.BankAccountHandler;

public class AccountEditDriver {
    private static boolean looping;
    private static BankAccountHandler baHandler = BankData.getBaHandler();
    private static BankAccountEditMenuController cec = new BankAccountEditMenuController();
    public void doMain() {
    }
}
