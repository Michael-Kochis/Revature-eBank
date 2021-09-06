package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.controllers.CentralMenuController;
import com.revature.mikeworks.enums.BankSecurity;
import com.revature.mikeworks.handlers.BankAccountHandler;
import com.revature.mikeworks.handlers.CustomerHandler;

public class BankUserDriver {
    private static final CentralMenuController cmc = new CentralMenuController();
    private static final AccountApprovalDriver aaDriver = new AccountApprovalDriver();
    private static final AccountEditDriver aeDriver = new AccountEditDriver();
    private static final BankAccountDriver baDriver = new BankAccountDriver();
    private static final CustomerDirectoryDriver cdDriver = new CustomerDirectoryDriver();
    private static final CustomerEditDriver ceDriver = new CustomerEditDriver();
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
            BankUserDriver.mainStep(option);
        }

        teardown();
    }

    private static void mainStep(int option) {
        switch(option) {
            case (1) -> processProfileOptionsMenu();
            case (2) -> processBankAccountOptionsMenu();
            case (3) -> porcessViewCustomerInformation();
            case (4) -> processApproveDenyAccounts();
            case (5) -> proessEditProfiles();
            case (6) -> processEditBankAccounts();
            default -> { looping = false; }
        }
    }

    private static void processEditBankAccounts() {
        if (BankSecurity.authEqualOrGreater(BankSecurity.ADMIN, whoAmI.getSecurity()) ) {
            aeDriver.doMain(baHandler);
        }
    }

    private static void proessEditProfiles() {
        if (BankSecurity.authEqualOrGreater(BankSecurity.ADMIN, whoAmI.getSecurity())) {
            ceDriver.doMain(cHandler);
        }
    }

    private static void processApproveDenyAccounts() {
        if(BankSecurity.authEqualOrGreater(BankSecurity.EMPLOYEE, whoAmI.getSecurity())) {
            aaDriver.doMain(baHandler);
        }
    }

    private static void porcessViewCustomerInformation() {
        if (BankSecurity.authEqualOrGreater(BankSecurity.EMPLOYEE, whoAmI.getSecurity()) ) {
            cdDriver.doMain(cHandler, whoAmI);
        }
    }

    private static void processBankAccountOptionsMenu() {
        baDriver.doMain(baHandler, whoAmI);
    }

    private static void processProfileOptionsMenu() {
        cdDriver.doMain(cHandler, whoAmI);
    }
}
