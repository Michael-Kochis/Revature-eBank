package com.revature.mikeworks.components;

import com.revature.mikeworks.enums.BankSecurity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Customer  {
    @Getter @Setter private int personID;
    @Getter @Setter private String username;
    @Getter private PHash password;
    @Getter @Setter private BankSecurity security;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String email;

    public Customer() {
        this.setUsername("");
        this.password =  new PHash();
        this.security = BankSecurity.CUSTOMER;
    }

    public Customer(int neoID, String neoName, String neoFirst, String neoLast, String neoEmail, BankSecurity neoSec) {
        this.personID = neoID;
        this.username = neoName;
        this.password = new PHash();
        this.firstName = neoFirst;
        this.lastName = neoLast;
        this.email = neoEmail;
        this.security = neoSec;
    }

    public void setHash(String neoHash) {
        if (this.password == null)
            this.password = new PHash();
        this.password.setHash(neoHash);
    }

    public void setPassword(String raw) {
        this.password.setPassword(raw);
    }

    public boolean isEmployee() {
        return ((this.security == BankSecurity.EMPLOYEE) || (this.security == BankSecurity.ADMIN));
    }

    public boolean isAdmin() {
        return (this.security == BankSecurity.ADMIN);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Username: " + this.username);
        sb.append("\n");
        sb.append("Name: " + this.firstName + " " + this.lastName);
        sb.append("\n");
        sb.append("Email: " + this.email);
        sb.append("\nAccess level: " + this.security);

        return sb.toString();
    }


}
