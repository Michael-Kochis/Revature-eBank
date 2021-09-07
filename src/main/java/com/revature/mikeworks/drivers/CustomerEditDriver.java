package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.controllers.CustomerEditMenuController;
import com.revature.mikeworks.enums.BankSecurity;
import com.revature.mikeworks.handlers.CustomerHandler;
import com.revature.mikeworks.utils.ValidScanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerEditDriver {
    private static boolean looping;
    private static BankSecurity auth;
    private static Customer target;
    private static CustomerHandler cHandler = BankData.getCHandler();
    private static CustomerEditMenuController cec = new CustomerEditMenuController();
    private static final ValidScanner scan = new ValidScanner();
    private static final Logger log = LogManager.getLogger(CustomerEditDriver.class);

    public void doMain() {
        this.target = BankData.getWhoAmI();
        this.auth = BankData.getWhoAmI().getSecurity();
        this.looping = BankSecurity.authEqualOrGreater(BankSecurity.ADMIN, auth);

        while(looping) {
            int option = cec.readOption(auth);
            mainStep(option);
        }
    }

    private void mainStep(int option) {
        switch(option) {
            case (1) -> {
                doListAllCustomers();
                break;
            }
            case (2) -> {
                doSelectTarget();
                break;
            }
            case (3) -> {
                doUpdateUserName();
                break;
            }
            case (4) -> {
                doUpdatePassword();
                break;
            }
            case (5) -> {
                doUpdateFirstName();
                break;
            }
            case (6) -> {
                doUpdateLastName();
                break;
            }
            case (7) -> {
                doUpdateEmail();
                break;
            }
            case (8) -> {
                doMakeEmployee();
                break;
            }
            case (9) -> {
                doPromoteAdmin();
                break;
            }
            default -> looping = false;
        }
    }

    private void doUpdateUserName() {
        System.out.println("Enter desired new user name:");
        String neoName = scan.readString();
        cHandler.updateName(target.getUsername(), neoName);
    }

    private void doSelectTarget() {
        System.out.println("Select username to edit");
        String newTarget = scan.readString();

        if (cHandler.contains(newTarget)) {
            this.target = cHandler.getCustomerByUsername(newTarget);
        } else {
            log.warn("User not found by username: " + newTarget);
        }
    }

    private void doListAllCustomers() {
        cHandler.showAll();
    }

    private void doPromoteAdmin() {
        cHandler.changeAuth(target.getUsername(), BankSecurity.ADMIN);
    }

    private void doMakeEmployee() {
        cHandler.changeAuth(target.getUsername(), BankSecurity.EMPLOYEE);
    }

    private void doUpdatePassword() {
        System.out.println("Enter new password:");
        String neoPass = scan.readString();
        cHandler.updatePassword(target.getUsername(), neoPass);
    }

    private void doUpdateFirstName() {
        System.out.println("Enter new first name:");
        String neoFirst = scan.readString();
        cHandler.updateFirstName(target.getUsername(), neoFirst);
    }

    private void doUpdateLastName() {
        System.out.println("Enter new last name:");
        String neoLast = scan.readString();
        cHandler.updateLastName(target.getUsername(), neoLast);
    }

    private void doUpdateEmail() {
        System.out.println("Enter new email address:");
        String neoEmail = scan.readString();
        cHandler.updateEmail(target.getUsername(), neoEmail);
    }
}
