package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.handlers.BankAccountHandler;
import com.revature.mikeworks.handlers.CustomerHandler;

public class BankUserDriver {
    public static Customer whoAmI;
    public static CustomerHandler cHandler;
    public static BankAccountHandler baHandler;

    private void setup(Customer loggedIn, CustomerHandler cHandler) {
        BankUserDriver.whoAmI = loggedIn;
        BankUserDriver.cHandler = cHandler;
        BankUserDriver.baHandler = new BankAccountHandler();
        baHandler.loadAll();
    }

    private void teardown() {
        baHandler.saveAll();
    }

    public void doMain(Customer loggedIn, CustomerHandler cHandler) {
        setup(loggedIn, cHandler);

        System.out.println("User logged in: " + loggedIn.getUsername());

        teardown();
    }
}
