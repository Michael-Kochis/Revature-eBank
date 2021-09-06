package com.revature.mikeworks.enums;

public enum BankAccountStatus {
    APPLIED, APPROVED, REJECTED, OPEN, CLOSED;

    public  int toInt(BankAccountStatus status) {
        if (status == APPROVED) {
            return 2;
        } else if (status == REJECTED) {
            return 3;
        } else if (status == OPEN) {
            return 4;
        } else if (status == CLOSED) {
            return 5;
        } else {
            return 1;
        }
    }

    public  BankAccountStatus fromInt(int value) {
        switch (value) {
            case (2): return APPROVED;
            case (3): return REJECTED;
            case (4): return OPEN;
            case (5): return CLOSED;
            default: return APPLIED;
        }
    }

    public String toString(BankAccountStatus status) {
        switch (status) {
            case APPLIED: return "Applied";
            case APPROVED: return "Approved";
            case CLOSED: return "Closed";
            case OPEN: return "Open";
            case REJECTED: return "Rejected";
            default: {
                return "Error";
            }
        }
    }
}
