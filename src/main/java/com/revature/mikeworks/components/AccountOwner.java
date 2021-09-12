package com.revature.mikeworks.components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
public class AccountOwner {
    @Getter @Setter Long bankID;
    @Getter @Setter Long ownerID;
    @Getter @Setter Long accountID;

    public String toString() {
        return this.getBankID() + " " + this.getOwnerID() + " " + this.getAccountID();
    }
}
