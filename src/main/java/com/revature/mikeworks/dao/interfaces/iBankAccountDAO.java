package com.revature.mikeworks.dao.interfaces;

import com.revature.mikeworks.components.BankAccount;

import java.util.HashMap;

public interface iBankAccountDAO {
    public void deleteAccount(BankAccount toDelete);
    public HashMap<Long, BankAccount> readAccounts();
    public void updateAccount(Long accountNumber);
    public void writeAccount(BankAccount input);
    }
