package com.revature.mikeworks.handlers;

import com.revature.mikeworks.components.BankAccount;
import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.dao.BankAccountDAO;
import lombok.Getter;

import java.util.HashMap;

public class BankAccountHandler {
    private static long nextAccountNumber;
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
        setNextBankAccountNumber();
    }

    public void saveAll() {
        dao.writeAccounts(this.accountList);
    }

    public void showMyAccounts() {
        String thisUser = BankData.getWhoAmI().getUsername();
        for (BankAccount entry : this.accountList.values()) {
            if (entry.getOwner().contains(thisUser)) {
                System.out.println(entry.toString());
                System.out.println();
            }
        }
    }

    public long getNextAccountNumber() {
        BankAccountHandler.nextAccountNumber += 1L;
        return BankAccountHandler.nextAccountNumber;
    }

    private void setNextBankAccountNumber() {
        for (Long entry : this.accountList.keySet()) {
            if (entry > BankAccountHandler.nextAccountNumber)
                BankAccountHandler.nextAccountNumber = entry;
        }
    }
}
