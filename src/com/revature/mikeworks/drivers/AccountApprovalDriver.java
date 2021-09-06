package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.controllers.AccountApprovalMenuController;
import com.revature.mikeworks.handlers.BankAccountHandler;

public class AccountApprovalDriver {
    private static boolean looping;
    private static BankAccountHandler baHandler = BankData.getBaHandler();
    private static AccountApprovalMenuController cec = new AccountApprovalMenuController();
    public void doMain() {
    }
}
