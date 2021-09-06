package com.revature.mikeworks.handlers;

import com.revature.mikeworks.components.BankAccount;
import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.dao.BankAccountDAO;
import com.revature.mikeworks.enums.BankAccountStatus;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class BankAccountHandler {
    private static long nextAccountNumber;
    @Getter private HashMap<Long, BankAccount> accountList;
    private static final BankAccountDAO dao = new BankAccountDAO();
    private static final Logger log = LogManager.getLogger(BankAccountHandler.class);

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

    public boolean accountExists(Long account) {
        return this.accountList.containsKey(account);
    }

    public void showMyAccounts() {
        String thisUser = BankData.getWhoAmI().getUsername();
        for (BankAccount entry : this.accountList.values()) {
            if (entry.getOwner().contains(thisUser)) {
                System.out.println(entry);
                System.out.println();
            }
        }
    }

    public void deposit(long accountNumber, double amount) {
        if (amount < 0 ) {
            log.error("Attempt to deposit negative money into: " + accountNumber);
        } else if (!this.validAccount(accountNumber)) {
            log.error("Attempt to deposit money into invalid account: " + accountNumber);
        } else {
            BankAccount editThis = this.accountList.get(accountNumber);
            editThis.setBalance(editThis.getBalance() + amount);
            this.accountList.remove(accountNumber);
            this.accountList.put(accountNumber, editThis);
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

    public void transfer(long from, long to, double amount) {
        if ((validAccount(from)) && (validAccount(to)) ) {
            if (amount > this.accountList.get(from).getBalance()) {
                log.error("Not enough money for transfer: " + from + " " + to);
            } else {
                withdraw(from, amount);
                deposit(to, amount);
            }

        } else {
            log.error("One of these accounts not valid for transfer: " + from + " " + to);
        }
    }

    private boolean validAccount(long accountNumber) {
        if (this.accountExists(accountNumber)) {
            BankAccount testThis = this.accountList.get(accountNumber);
            return (testThis.getStatus() == BankAccountStatus.OPEN);
        } else {
            return false;
        }
    }

    public void withdraw(long accountNumber, double amount) {
        if (amount < 0 ) {
            log.error("Attempt to withdraw negative money from: " + accountNumber);
        } else if (!this.validAccount(accountNumber)) {
            log.error("Attempt to withdraw money from invalid account: " + accountNumber);
        } else {
            BankAccount editThis = this.accountList.get(accountNumber);
            if (amount > editThis.getBalance()) {
                log.error("Attempt to withdraw more money than in account: " + accountNumber);
            } else {
                editThis.setBalance(editThis.getBalance() - amount);
                this.accountList.remove(accountNumber);
                this.accountList.put(accountNumber, editThis);
            }
        }
    }

    public void showApplied() {
        for (BankAccount entry : this.accountList.values()) {
            if (entry.getStatus() == BankAccountStatus.APPLIED) {
                System.out.println(entry);
                System.out.println();
            }
        }
    }

    public void setAccountStatus(Long account, BankAccountStatus neoStatus) {
        if (this.accountExists(account)) {
            BankAccount editThis = this.accountList.get(account);
            editThis.setStatus(neoStatus);
            this.accountList.remove(account);
            this.accountList.put(account, editThis);
        } else {
            log.error("Attempt to modify non-existing account: " + account);
        }
    }
}
