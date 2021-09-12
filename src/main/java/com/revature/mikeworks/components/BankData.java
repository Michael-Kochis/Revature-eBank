package com.revature.mikeworks.components;

import com.revature.mikeworks.handlers.BankAccountHandler;
import com.revature.mikeworks.handlers.CustomerHandler;
import lombok.Getter;
import lombok.Setter;

public class BankData {
    private static CustomerHandler cHandler = new CustomerHandler();
    private static BankAccountHandler baHandler = new BankAccountHandler();
    @Getter @Setter
    private static Customer whoAmI;

    public static CustomerHandler getCHandler() {
        if (cHandler == null)
            cHandler = new CustomerHandler();
        return cHandler;
    }

    public static BankAccountHandler getBaHandler() {
        if (baHandler == null)
            baHandler = new BankAccountHandler();
        return baHandler;
    }
}
