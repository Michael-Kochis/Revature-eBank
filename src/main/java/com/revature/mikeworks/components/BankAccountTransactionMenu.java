package com.revature.mikeworks.components;

import com.revature.mikeworks.enums.BankSecurity;

public class BankAccountTransactionMenu extends BankMenuAuth {
    public BankAccountTransactionMenu() {
        this.addMenuItem(0, "Return to previous menu");
        this.addMenuItem(1, "Switch active account");
        this.addMenuItem(2, "Deposit");
        this.addMenuItem(3, "Withdraw");
        this.addMenuItem(4, "Transfer");
        this.addMenuItem(5, "Cancel account", BankSecurity.ADMIN);
    }
}
