package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.CentralMenu;
import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.controllers.CentralMenuController;
import com.revature.mikeworks.handlers.BankAccountHandler;
import com.revature.mikeworks.handlers.CustomerHandler;

public class BankUserDriver {
    private static final CentralMenuController cmc = new CentralMenuController();
    private static boolean looping;
    public static Customer whoAmI;
    public static CustomerHandler cHandler;
    public static BankAccountHandler baHandler;

    private void setup(Customer loggedIn, CustomerHandler cHandler) {
        BankUserDriver.whoAmI = loggedIn;
        BankUserDriver.cHandler = cHandler;
        BankUserDriver.baHandler = new BankAccountHandler();
        baHandler.loadAll();
        looping = true;
    }

    private void teardown() {
        baHandler.saveAll();
    }

    public void doMain(Customer loggedIn, CustomerHandler cHandler) {
        setup(loggedIn, cHandler);

        while (looping) {
            int option = cmc.readOption(whoAmI.getSecurity());

        }

        teardown();
    }
}
