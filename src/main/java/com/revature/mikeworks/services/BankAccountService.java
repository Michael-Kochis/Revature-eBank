package com.revature.mikeworks.services;

import com.revature.mikeworks.components.AccountOwner;
import com.revature.mikeworks.components.BankAccount;
import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.dao.AccountOwnerDAO;
import com.revature.mikeworks.dao.BankAccountDAO;
import com.revature.mikeworks.dao.LogDAO;

import java.util.HashMap;

public class BankAccountService {
    private static final BankAccountDAO dao = new BankAccountDAO();
    private static final AccountOwnerDAO daoAO = new AccountOwnerDAO();
    private static final LogDAO daoL = new LogDAO();

    public HashMap<Long, BankAccount> loadAll() {
        return dao.readAccounts();
    }

    public void assignAccountOwners() {
        dao.assignAccountOwners();
    }

    public void updateAccount(Long accountNumber, int type, Double amount, Long otherAccount) {
        dao.updateAccount(accountNumber);
        daoL.createLogEntry((long) BankData.getWhoAmI().getPersonID(),
                type, accountNumber, otherAccount, amount, "");        }

    public void updateAccount(BankAccount editThis) {
        dao.updateAccount(editThis);
    }

    public void writeAccountOwner(AccountOwner newAO) {
        daoAO.writeAccountOwner(newAO);
    }
}

