package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankAccount;
import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.controllers.BankAccountApplyMenuController;
import com.revature.mikeworks.enums.BankAccountStatus;
import com.revature.mikeworks.handlers.BankAccountHandler;
import com.revature.mikeworks.utils.ValidScanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccountApplyDriver {
    private static boolean looping;
    private static final BankAccountApplyMenuController baac = new BankAccountApplyMenuController();
    private static BankAccount neoAccount;
    private static BankAccountHandler baHandler = BankData.getBaHandler();
    private static final ValidScanner scan = new ValidScanner();
    private static Logger log = LogManager.getLogger(BankAccountApplyDriver.class);

    private void initializeNeoAccount() {
        neoAccount = new BankAccount();
        neoAccount.addOwner(BankData.getWhoAmI().getUsername());
        neoAccount.setAccountNumber(baHandler.getNextAccountNumber() );
        neoAccount.setStatus(BankAccountStatus.APPLIED);
    }

    public void doMain() {
        looping = true;
        initializeNeoAccount();

        while (looping) {
            System.out.println(neoAccount.toString());
            System.out.println();
            int option = baac.readOption();
            mainStep(option);
        }
    }

    private void mainStep(int option) {
        switch (option) {
            case (1): doTypeChange(); break;
            case (2): doAddOwner(); break;
            case (3): doRemoveOwner(); break;
            case (4): doApplyForAccount(); break;
            default: looping = false;
        }
    }

    private void doApplyForAccount() {
        baHandler.add(neoAccount);
        log.info("User applied for new account: " + neoAccount);
    }

    private void doAddOwner() {
        System.out.println("Enter username to join account");
        String username = scan.readString();
        neoAccount.addOwner(username);
    }

    private void doRemoveOwner() {
        System.out.println("Enter username to remove from account");
        String username = scan.readString();
        neoAccount.addOwner(username);
    }

    private void doTypeChange() {
        if (neoAccount.getType().equals("checking")) {
            neoAccount.setType("savings");
        } else {
            neoAccount.setType("checking");
        }
    }
}
