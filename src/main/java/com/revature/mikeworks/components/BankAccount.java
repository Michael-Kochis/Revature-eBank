package com.revature.mikeworks.components;

import com.revature.mikeworks.enums.BankAccountStatus;
import com.revature.mikeworks.enums.BankAccountType;
import com.revature.mikeworks.handlers.CustomerHandler;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.TreeSet;

public class BankAccount implements Serializable {
    private static final Logger log = LogManager.getLogger(BankAccount.class);
    private static final CustomerHandler cHandler = BankData.getCHandler();
    @Getter @Setter private BankAccountType type;
    private TreeSet<String> owner = new TreeSet<>();
    @Getter @Setter private double balance;
    @Getter @Setter private long accountNumber;
    @Getter @Setter private BankAccountStatus status;

    public BankAccount() {
        this.setType(BankAccountType.CHECKING);
        this.setStatus(BankAccountStatus.APPLIED);
    }

    public BankAccount(long num, BankAccountType nType, BankAccountStatus nStatus, double nBal) {
        this.setAccountNumber(num);
        this.setType(nType);
        this.setStatus(nStatus);
        this.setBalance(nBal);
    }

    public void addOwner(String neoOwner) {
        if (cHandler.contains(neoOwner))
            this.owner.add(neoOwner);
    }

    public void removeOwner(String exOwner) {
        if (this.owner.size() > 1) {
            this.owner.remove(exOwner);
        } else {
            log.error("Cannot remove last owner from account: " + this.accountNumber);
        }
    }

    public TreeSet<String> getOwner() {
        return this.owner;
    }

    public String toString() {
        StringBuilder returnThis = new StringBuilder();
        returnThis.append(this.accountNumber);
        returnThis.append(": ");
        returnThis.append(this.type);
        returnThis.append("\n");
        returnThis.append("Balance: ").append(this.getBalance() ).append("\n");
        returnThis.append("Owner List: ").append(this.owner.toString() ).append("\n");
        returnThis.append("Status: ").append(this.getStatus() );

        return returnThis.toString();
    }
}
