package com.revature.mikeworks.components;

import lombok.Getter;
import lombok.Setter;

public class BankAccount {
    private String type = "checking";
    @Getter @Setter private double balance;
    @Getter @Setter private int accountNumber;

    public String getType() {
        return this.type;
    }

    public void setType(String newType) {
        this.type = newType;
    }

}
