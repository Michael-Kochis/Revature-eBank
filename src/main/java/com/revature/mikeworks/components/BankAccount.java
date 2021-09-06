package com.revature.mikeworks.components;

import com.revature.mikeworks.enums.BankAccountStatus;
import com.revature.mikeworks.handlers.CustomerHandler;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.TreeSet;

public class BankAccount implements Serializable {
    private static Logger log = LogManager.getLogger(BankAccount.class);
    private static final CustomerHandler cHandler = BankData.getCHandler();
    private String type = "checking";
    private TreeSet<String> owner = new TreeSet<String>();
    @Getter @Setter private double balance;
    @Getter @Setter private long accountNumber;
    @Getter @Setter private BankAccountStatus status;

    public String getType() {
        return this.type;
    }

    public void setType(String newType) {
        this.type = newType;
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
        returnThis.append("Balance: " + this.getBalance() + "\n");
        returnThis.append("Owner List: " + this.owner.toString() +"\n");
        returnThis.append("Status: " + this.getStatus() );

        return returnThis.toString();
    }
}
