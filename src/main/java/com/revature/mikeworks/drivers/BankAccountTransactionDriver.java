package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankAccount;
import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.controllers.BankAccountTransactionMenuController;
import com.revature.mikeworks.enums.BankAccountStatus;
import com.revature.mikeworks.enums.BankSecurity;
import com.revature.mikeworks.handlers.BankAccountHandler;
import com.revature.mikeworks.utils.ValidScanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccountTransactionDriver {
    private boolean looping;
    private static BankAccount target;
    private static final BankAccountHandler baHandler = BankData.getBaHandler();
    private static final BankAccountTransactionMenuController batc = new BankAccountTransactionMenuController();
    private static final Logger log = LogManager.getLogger(BankAccountTransactionDriver.class);
    private static final ValidScanner scan = new ValidScanner();

    public void doMain() {
        looping = true;

        while (looping) {
            int option = batc.readOption(BankData.getWhoAmI().getSecurity());
            mainStep(option);
        }
    }

    private void mainStep(int option) {
        switch (option) {
            case (1) -> doSwitchTarget();
            case (2) -> doDeposit();
            case (3) -> doWithdraw();
            case (4) -> doTransfer();
            case (5) -> doCancelAccount();
            default -> looping = false;
        }
    }

    private void doCancelAccount() {
        if (target != null) {
            if (BankSecurity.authEqualOrGreater(BankSecurity.ADMIN, BankData.getWhoAmI().getSecurity())) {
                baHandler.updateStatus(target.getAccountNumber(), BankAccountStatus.CLOSED);
            } else {
                log.error("Attempt by user " + BankData.getWhoAmI().getUsername() + " to cancel account "
                        + target.getAccountNumber());
            }
        } else {
            System.out.println("Select an account first.");
        }
    }

    private void doDeposit() {
        if (target == null) {
            System.out.println("Select an account first.");
        } else {
            System.out.println("Amount to deposit: ");
            double amount = scan.readDouble();

            baHandler.deposit(target.getAccountNumber(), amount);
        }
    }

    private void doSwitchTarget() {
        System.out.println("Which account number?");
        Long seeking = scan.readLong();
        if (baHandler.contains(seeking)) {
            if (BankSecurity.authEqualOrGreater(BankSecurity.ADMIN, BankData.getWhoAmI().getSecurity())
                || baHandler.isMyAccount(seeking, BankData.getWhoAmI().getUsername())) {
                target = baHandler.getAccountByNumber(seeking);
            } else {
                log.warn("Attempt by " + BankData.getWhoAmI().getUsername() +
                        " to access account " + seeking);
            }
        } else {
            log.error("Attempt to access invalid account " + seeking);
        }
    }

    private void doTransfer() {
        if (target == null) {
            System.out.println("Select an account first.");
        } else {
            System.out.println("Select account to transfer to:");
            Long destination = scan.readLong();
            System.out.println("Amount to deposit: ");
            double amount = scan.readDouble();

            baHandler.transfer(target.getAccountNumber(), destination, amount);
        }
    }

    private void doWithdraw() {
        if (target == null) {
            System.out.println("Select an account first.");
        } else {
            System.out.println("Amount to withdraw: ");
            double amount = scan.readDouble();

            baHandler.withdraw(target.getAccountNumber(), amount);
        }
    }

}
