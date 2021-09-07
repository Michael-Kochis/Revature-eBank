package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.controllers.BankAccountMenuController;
import com.revature.mikeworks.handlers.BankAccountHandler;

public class BankAccountDriver {
    private static boolean looping;
    private static final BankAccountApplyDriver baaDriver = new BankAccountApplyDriver();
    private static final BankAccountTransactionDriver batDriver = new BankAccountTransactionDriver();
    private static final BankAccountHandler baHandler = BankData.getBaHandler();
    private static final BankAccountMenuController cec = new BankAccountMenuController();

    public void doMain() {
        looping = true;

        while (looping) {
            int option = cec.readOption(BankData.getWhoAmI().getSecurity());
            mainstep(option);
        }
    }

    private void mainstep(int option) {
        switch (option) {
            case (1) -> doListMyAccounts();
            case (2) -> doApplyAccount();
            case (3) -> doAccountTransactions();
            default -> looping = false;
        }
    }

    private void doAccountTransactions() {
        batDriver.doMain();
    }

    private void doApplyAccount() {
        baaDriver.doMain();
    }

    private void doListMyAccounts() {
        baHandler.showMyAccounts();
    }
}
