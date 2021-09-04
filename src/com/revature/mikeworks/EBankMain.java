package com.revature.mikeworks;

import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.components.LoginRegisterMenu;
import com.revature.mikeworks.drivers.BankDriver;

public class EBankMain {
    public static void main(String[] args) {
        BankDriver driver = new BankDriver();
        driver.runMain();
    }
}
