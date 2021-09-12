package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.AccountOwner;
import com.revature.mikeworks.components.BankAccount;
import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.controllers.BankAccountApplyMenuController;
import com.revature.mikeworks.dao.AccountOwnerDAO;
import com.revature.mikeworks.enums.BankAccountStatus;
import com.revature.mikeworks.enums.BankAccountType;
import com.revature.mikeworks.handlers.BankAccountHandler;
import com.revature.mikeworks.handlers.CustomerHandler;
import com.revature.mikeworks.utils.ValidScanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccountApplyDriver {
    private static boolean looping;
    private static final BankAccountApplyMenuController baac = new BankAccountApplyMenuController();
    private static BankAccount neoAccount;
    private static final BankAccountHandler baHandler = BankData.getBaHandler();
    private static final CustomerHandler cHandler = BankData.getCHandler();
    private static final ValidScanner scan = new ValidScanner();
    private static final Logger log = LogManager.getLogger(BankAccountApplyDriver.class);

    private void initializeNeoAccount() {
        neoAccount = new BankAccount();
        neoAccount.setAccountNumber(baHandler.getNextAccountNumber() );
        neoAccount.addOwner(BankData.getWhoAmI().getUsername(),
                new AccountOwner(
                        AccountOwnerDAO.getNextNumber(),
                        (long)BankData.getWhoAmI().getPersonID(),
                        neoAccount.getAccountNumber()
                ));
        neoAccount.setStatus(BankAccountStatus.APPLIED);
    }

    public void doMain() {
        looping = true;
        initializeNeoAccount();

        while (looping) {
            System.out.println(neoAccount.toString());
            System.out.println();
            int option = baac.readOption();
            mainStep(option);
        }
    }

    private void mainStep(int option) {
        switch (option) {
            case (1) -> doTypeChange();
            case (2) -> doAddOwner();
            case (3) -> doRemoveOwner();
            case (4) -> doApplyForAccount();
            default -> looping = false;
        }
    }

    private void doApplyForAccount() {
        baHandler.add(neoAccount);
        log.info("User applied for new account: " + neoAccount);
    }

    private void doAddOwner() {
        changeAccount();
        System.out.println("Enter username to join account");
        String username = scan.readString();
        Long ownerID = (long)cHandler.getCustomerByUsername(username).getPersonID();
        baHandler.addOwnerRecord(ownerID, neoAccount.getAccountNumber());
    }

    private void doRemoveOwner() {
        changeAccount();
        System.out.println("Enter username to remove from account");
        String username = scan.readString();
        neoAccount.removeOwner(username);
    }

    private void doTypeChange() {
        if (neoAccount.getType().equals(BankAccountType.SAVINGS)) {
            neoAccount.setType(BankAccountType.SAVINGS);
        } else {
            neoAccount.setType(BankAccountType.CHECKING);
        }
    }

    private void changeAccount() {
        baHandler.showMyAccounts();
        System.out.println("Which existing/applied account");
        Long boot = scan.readLong();
        neoAccount = baHandler.getAccountByNumber(boot);
        if (neoAccount == null) {
            neoAccount = baHandler.createNewAccount();
            baHandler.addOwnerRecord(BankData.getWhoAmI().getPersonID(), neoAccount.getAccountNumber());
        }
        System.out.println(neoAccount);
    }
}
