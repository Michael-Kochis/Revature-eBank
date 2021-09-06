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

    public static boolean authEqualOrGreater(BankSecurity itemAuth, BankSecurity authToCheck) {
        boolean returnThis = false;

        if (itemAuth == BankSecurity.CUSTOMER) {
            returnThis = true;
        } else if (authToCheck == BankSecurity.ADMIN) {
            returnThis = true;
        } else {
            returnThis = (authToCheck == BankSecurity.EMPLOYEE);
        }

        return returnThis;
    }
}