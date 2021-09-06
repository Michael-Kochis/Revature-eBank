package com.revature.mikeworks.enums;

public enum BankAccountStatus {
    APPLIED, APPROVED, REJECTED, OPEN, CLOSED;

    public int toInt(BankAccountStatus status) {
        if (status == BankAccountStatus.APPROVED) {
            return 2;
        } else if (status == BankAccountStatus.REJECTED) {
            return 3;
        } else if (status == BankAccountStatus.OPEN) {
            return 4;
        } else if (status == BankAccountStatus.CLOSED) {
            return 5;
        } else {
            return 1;
        }
    }

    public BankAccountStatus fromInt(int value) {
        switch (value) {
            case (2): return BankAccountStatus.APPROVED;
            case (3): return BankAccountStatus.REJECTED;
            case (4): return BankAccountStatus.OPEN;
            case (5): return BankAccountStatus.CLOSED;
            default: return BankAccountStatus.APPLIED;
        }
    }
}
