package com.revature.mikeworks.components;

import com.revature.mikeworks.enums.BankSecurity;

public class AccountApprovalMenu extends BankMenuAuth {
    public AccountApprovalMenu() {
        this.addMenuItem(0, "Return to previous menu");
        this.addMenuItem(1, "Approve an account");
        this.addMenuItem(2, "Deny an account");
    }
}
