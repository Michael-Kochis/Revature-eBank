package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.controllers.CustomerDirectoryMenuController;
import com.revature.mikeworks.handlers.CustomerHandler;

public class CustomerDirectoryDriver {
    private static boolean looping;
    private static CustomerHandler cHandler = BankData.getCHandler();
    private static CustomerDirectoryMenuController cdc = new CustomerDirectoryMenuController();

    public void doMain() {
        looping = true;
        while (looping) {
            int option = cdc.readOption();
            mainStep(option);
        }
    }

    private void mainStep(int option) {
        if (option == 1) {
            cHandler.showAll();
        } else {
            looping = false;
        }
    }
}
