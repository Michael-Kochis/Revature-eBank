package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.controllers.BankAccountMenuController;
import com.revature.mikeworks.handlers.BankAccountHandler;
import com.revature.mikeworks.handlers.CustomerHandler;

public class BankAccountDriver {
    private static boolean looping;
    private static final BankAccountHandler baHandler = BankData.getBaHandler();
    private static BankAccountMenuController cec = new BankAccountMenuController();
    public void doMain() {
    }
}
