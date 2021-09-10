package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.controllers.CustomerDirectoryMenuController;
import com.revature.mikeworks.dao.CustomerDAO;
import com.revature.mikeworks.handlers.CustomerHandler;
import com.revature.mikeworks.utils.ValidScanner;

public class CustomerDirectoryDriver {
    private static boolean looping;
    private static CustomerHandler cHandler = BankData.getCHandler();
    private static CustomerDirectoryMenuController cdc = new CustomerDirectoryMenuController();
    private static ValidScanner scan = new ValidScanner();

    public void doMain() {
        looping = true;
        while (looping) {
            System.out.println(BankData.getWhoAmI().toString() );
            int option = cdc.readOption();
            mainStep(option);
        }
    }

    private void mainStep(int option) {
        switch (option) {
            case (1) -> doUpdateUsername();
            case (2) -> doUpdatePassword();
            case (3) -> doUpdateFirstName();
            case (4) -> doUpdateLastName();
            case (5) -> doUpdateEmail();
            default -> looping = false;
        }
    }

    private void doUpdateFirstName() {
        System.out.println("Enter your new user name");
        String neoName = scan.readString();
        BankData.getWhoAmI().setFirstName(neoName);
        CustomerDAO.writeCustomer(BankData.getWhoAmI());
    }

    private void doUpdatePassword() {
        System.out.println("Enter your new password");
        String neoPass = scan.readString();
        BankData.getWhoAmI().setPassword(neoPass);
        CustomerDAO.writeCustomer(BankData.getWhoAmI());
    }

    private void doUpdateUsername() {
        System.out.println("Enter your new username");
        String neoName = scan.readString();
        if (cHandler.contains(neoName)) {
            System.out.println("That name is taken.");
        } else {
            BankData.getWhoAmI().setUsername(neoName);
            CustomerDAO.writeCustomer(BankData.getWhoAmI());
        }
    }
}
