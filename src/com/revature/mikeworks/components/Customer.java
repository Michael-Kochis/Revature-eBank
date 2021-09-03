package com.revature.mikeworks.components;

import com.revature.mikeworks.enums.BankSecurity;
import lombok.Getter;
import lombok.Setter;

public class Customer {
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter @Setter private BankSecurity security;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String email;

    public Customer() {
        this.security = BankSecurity.CUSTOMER;
    }

    public boolean isEmployee() {
        return ((this.security == BankSecurity.EMPLOYEE) || (this.security == BankSecurity.ADMIN));
    }

    public boolean isAdmin() {
        return (this.security == BankSecurity.ADMIN);
    }


}
