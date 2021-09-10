package com.revature.mikeworks.enums;

public enum BankAccountType {
    CHECKING, SAVINGS;

    public static int toInt(BankAccountType input) {
        switch(input) {
            case SAVINGS -> {
                return 2;
            }
            default -> {
                return 1;
            }
        }
    }

    public static BankAccountType fromInt(int input) {
        switch (input) {
            case (2) -> {
                return SAVINGS;
            }
            default -> {
                return CHECKING;
            }
        }
    }
}
