package com.revature.mikeworks;

import com.revature.mikeworks.dao.JDBCConnector;
import com.revature.mikeworks.drivers.BankDriver;

public class EBankMain {
    public static void main(String[] args) {
        JDBCConnector.testDatabase();
        BankDriver driver = new BankDriver();
        driver.runMain();
    }
}
