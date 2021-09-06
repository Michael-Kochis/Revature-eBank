package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.controllers.CustomerDirectoryMenuController;
import com.revature.mikeworks.handlers.CustomerHandler;

public class CustomerDirectoryDriver {
    private static boolean looping;
    private static CustomerHandler cHandler = BankData.getCHandler();
    private static CustomerDirectoryMenuController cec = new CustomerDirectoryMenuController();

    public void doMain() {
    }
}
