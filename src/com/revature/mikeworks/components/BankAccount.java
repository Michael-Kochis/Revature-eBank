package com.revature.mikeworks.components;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BankAccount implements Serializable {
    private String type = "checking";
    @Getter @Setter private double balance;
    @Getter @Setter private long accountNumber;

    public String getType() {
        return this.type;
    }

    public void setType(String newType) {
        this.type = newType;
    }

}
