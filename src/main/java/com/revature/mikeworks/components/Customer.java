package com.revature.mikeworks.components;

import com.revature.mikeworks.enums.BankSecurity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Customer implements Serializable {
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter @Setter private BankSecurity security;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String email;

    public Customer() {
        this.setUsername("");
        this.security = BankSecurity.CUSTOMER;
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
