package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.controllers.CentralMenuController;
import com.revature.mikeworks.enums.BankSecurity;
import com.revature.mikeworks.handlers.BankAccountHandler;

public class BankUserDriver {
    private static final CentralMenuController cmc = new CentralMenuController();
    private static final AccountApprovalDriver aaDriver = new AccountApprovalDriver();
    private static final BankAccountDriver baDriver = new BankAccountDriver();
    private static final CustomerDirectoryDriver cdDriver = new CustomerDirectoryDriver();
    private static final CustomerEditDriver ceDriver = new CustomerEditDriver();
    private static boolean looping;
    public static Customer whoAmI;
    public static final BankAccountHandler baHandler = BankData.getBaHandler();
    public static final BankAccountTransactionDriver batDriver = new BankAccountTransactionDriver();

    private void setup() {
        whoAmI = BankData.getWhoAmI();
        baHandler.loadAll();
        baHandler.assignAccountOwners();
       looping = true;
    }

    public void doMain() {
        setup();

        while (looping) {
            int option = cmc.readOption(whoAmI.getSecurity());
            BankUserDriver.mainStep(option);
        }

    }

    private static void mainStep(int option) {
        switch(option) {
            case (1) -> processProfileOptionsMenu();
            case (2) -> processBankAccountOptionsMenu();
            case (3) -> processViewCustomerInformation();
            case (4) -> processApproveDenyAccounts();
            case (5) -> processEditProfiles();
            case (6) -> processEditBankAccounts();
            default -> { looping = false; }
        }
    }

    private static void processEditBankAccounts() {
        if (BankSecurity.authEqualOrGreater(BankSecurity.ADMIN, whoAmI.getSecurity()) ) {
            batDriver.doMain();
        }
    }

    private static void processEditProfiles() {
        if (BankSecurity.authEqualOrGreater(BankSecurity.ADMIN, whoAmI.getSecurity())) {
            ceDriver.doMain();
        }
    }

    private static void processApproveDenyAccounts() {
        if(BankSecurity.authEqualOrGreater(BankSecurity.EMPLOYEE, whoAmI.getSecurity())) {
            aaDriver.doMain();
        }
    }

    private static void processViewCustomerInformation() {
        if (BankSecurity.authEqualOrGreater(BankSecurity.EMPLOYEE, whoAmI.getSecurity()) ) {
            cdDriver.doMain();
        }
    }

    private static void processBankAccountOptionsMenu() {
        baDriver.doMain();
    }

    private static void processProfileOptionsMenu() {
        cdDriver.doMain();
    }
}
