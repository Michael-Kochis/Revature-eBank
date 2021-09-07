package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.controllers.AccountApprovalMenuController;
import com.revature.mikeworks.enums.BankAccountStatus;
import com.revature.mikeworks.enums.BankSecurity;
import com.revature.mikeworks.handlers.BankAccountHandler;
import com.revature.mikeworks.utils.ValidScanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountApprovalDriver {
    private static boolean looping;
    private static final BankAccountHandler baHandler = BankData.getBaHandler();
    private static final AccountApprovalMenuController aam = new AccountApprovalMenuController();
    private static final ValidScanner scan = new ValidScanner();
    private static final Logger log = LogManager.getLogger(AccountApprovalDriver.class);

    public void doMain() {
        BankSecurity auth = BankData.getWhoAmI().getSecurity();
        looping = BankSecurity.authEqualOrGreater(BankSecurity.EMPLOYEE, auth);

        while (looping) {
            baHandler.showApplied();
            int option = aam.readOption(auth);
            mainStep(option);
        }
    }

    private void mainStep(int option) {
        switch(option) {
            case (1) -> doApproveAccount();
            case (2) -> doDenyAccount();
            default -> looping = false;
        }
    }

    private long readInAccount() {
        return scan.readLong();
    }

    private void doDenyAccount() {
        System.out.println("Deny which account:");
        Long account = readInAccount();
        baHandler.setAccountStatus(account, BankAccountStatus.REJECTED);
        log.info(BankData.getWhoAmI().getUsername() + " denied account " + account);
    }

    private void doApproveAccount() {
        System.out.println("Approve which account:");
        Long account = readInAccount();
        baHandler.setAccountStatus(account, BankAccountStatus.OPEN);
        log.info(BankData.getWhoAmI().getUsername() + " approved account " + account);
    }
}
