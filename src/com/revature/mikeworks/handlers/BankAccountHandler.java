package com.revature.mikeworks.handlers;

import com.revature.mikeworks.components.BankAccount;
import com.revature.mikeworks.dao.BankAccountDAO;
import lombok.Getter;

import java.util.HashMap;

public class BankAccountHandler {
    @Getter private HashMap<Long, BankAccount> accountList;
    private static BankAccountDAO dao = new BankAccountDAO();

    public BankAccountHandler() {
        this.accountList = new HashMap<Long, BankAccount>();
    }

    public void add(BankAccount neoAccount) {
        if (this.contains(neoAccount)) {
            System.out.println("Cannot Add duplicate account " +  neoAccount);
        } else {
            this.accountList.put(neoAccount.getAccountNumber(), neoAccount);
        }
    }

    public boolean contains(BankAccount neoAcct) {
        return this.accountList.containsKey(neoAcct.getAccountNumber());
    }

    public int size() {
        return this.accountList.size();
    }

    public void loadAll() {
        this.accountList = dao.readAccounts();
    }

    public void saveAll() {
        dao.writeAccounts(this.accountList);
    }
}