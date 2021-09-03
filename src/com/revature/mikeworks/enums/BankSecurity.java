package com.revature.mikeworks.enums;

public enum BankSecurity {
    CUSTOMER, EMPLOYEE, ADMIN;

    public int toInt(BankSecurity value) {
        if (value == BankSecurity.CUSTOMER) {
            return 1;
        } else if (value == BankSecurity.EMPLOYEE) {
            return 2;
        } else if (value == BankSecurity.ADMIN) {
            return 3;
        } else {
            return -1;
        }
    }

    public BankSecurity fromInt(int level) {
        switch (level) {
            case (3): return BankSecurity.ADMIN;
            case (2): return BankSecurity.EMPLOYEE;
            default: return BankSecurity.CUSTOMER;
        }
    }
}
