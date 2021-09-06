package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.controllers.CustomerEditMenuController;
import com.revature.mikeworks.handlers.CustomerHandler;

public class CustomerEditDriver {
    private static boolean looping;
    private static CustomerHandler cHandler = BankData.getCHandler();
    private static CustomerEditMenuController cec = new CustomerEditMenuController();

    public void doMain() {
        this.looping = true;

        while(looping) {

        }
    }
}
