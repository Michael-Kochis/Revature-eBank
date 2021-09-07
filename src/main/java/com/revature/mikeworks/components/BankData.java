package com.revature.mikeworks.components;

import com.revature.mikeworks.handlers.BankAccountHandler;
import com.revature.mikeworks.handlers.CustomerHandler;
import lombok.Getter;
import lombok.Setter;

public class BankData {
    @Getter
    private static final CustomerHandler cHandler = new CustomerHandler();
    @Getter
    private static final BankAccountHandler baHandler = new BankAccountHandler();
    @Getter @Setter
    private static Customer whoAmI;
}
