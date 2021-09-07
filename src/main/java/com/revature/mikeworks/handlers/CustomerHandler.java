package com.revature.mikeworks.handlers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.dao.CustomerDAO;
import com.revature.mikeworks.enums.BankSecurity;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CustomerHandler implements Serializable {
    @Getter private HashMap<String, Customer> customerList;
    final static CustomerDAO dao = new CustomerDAO();
    private static final Logger log = LogManager.getLogger(CustomerHandler.class);

    public CustomerHandler() {
        this.customerList = new HashMap<>();
    }

    public void add(Customer neoCust) {
        if (this.contains(neoCust)) {
            System.out.println("Duplicate user cannot be added: " + neoCust);
        } else {
            this.customerList.put(neoCust.getUsername(), neoCust);
        }
    }

    public boolean contains(Customer neoCust) {
        return this.contains(neoCust.getUsername());
    }

    public void loadAll() {
        this.customerList = dao.readCustomers();
    }

    public void saveAll() {
        dao.writeCustomers(this.customerList);
    }

    public int size() {
        return this.customerList.size();
    }

    public String toString() {
        return this.customerList.toString();
    }

    public boolean contains(String neoUserName) {
        return this.customerList.containsKey(neoUserName);
    }

    public boolean canLogIn(String uname, String pass) {
        Customer testMyPassword = this.getCustomerByUsername(uname);

        return (pass.equals(testMyPassword.getPassword()) );
    }

    public Customer getCustomerByUsername(String username) {
        return this.customerList.get(username);
    }

    public void showAll() {
        for (Map.Entry<String,Customer> entry : this.customerList.entrySet()) {
            System.out.println(entry.toString());
            System.out.println();
        }
    }

    public void updateName(String username, String neoName) {
        if (this.contains(neoName)) {
            log.error("Attempt to duplicate username: " + neoName);
        } else {
            Customer editThis = this.getCustomerByUsername(username);
            editThis.setUsername(neoName);
            this.customerList.remove(username);
            this.customerList.put(neoName, editThis);
            log.info("User " + username + " is now known as " + neoName);
        }
    }

    public void updatePassword(String username, String neoPass) {
        if (this.contains(username)) {
            Customer editThis = this.getCustomerByUsername(username);
            editThis.setPassword(neoPass);
            this.customerList.remove(username);
            this.customerList.put(username, editThis);
            log.info("User " + username + " had their password reset by " +
                    BankData.getWhoAmI().getUsername() );
        } else {
            log.error("Attempt to edit non-existant user: " + username);
        }
    }

    public void updateFirstName(String username, String neoFirst) {
        if (this.contains(username)) {
            Customer editThis = this.getCustomerByUsername(username);
            editThis.setFirstName(neoFirst);
            this.customerList.remove(username);
            this.customerList.put(username, editThis);
            log.info("User " + username + " now has first name " + neoFirst );
        } else {
            log.error("Attempt to edit non-existant user: " + username);
        }
    }

    public void updateLastName(String username, String neoLast) {
        if (this.contains(username)) {
            Customer editThis = this.getCustomerByUsername(username);
            editThis.setLastName(neoLast);
            this.customerList.remove(username);
            this.customerList.put(username, editThis);
            log.info("User " + username + " now has last name " + neoLast );
        } else {
            log.error("Attempt to edit non-existant user: " + username);
        }
    }

    public void updateEmail(String username, String neoEmail) {
        if (this.contains(username)) {
            Customer editThis = this.getCustomerByUsername(username);
            editThis.setEmail(neoEmail);
            this.customerList.remove(username);
            this.customerList.put(username, editThis);
            log.info("User " + username + " now has email " + neoEmail );
        } else {
            log.error("Attempt to edit non-existant user: " + username);
        }
    }

    public void changeAuth(String username, BankSecurity auth) {
        if (this.contains(username)) {
            Customer editThis = this.getCustomerByUsername(username);
            editThis.setSecurity(auth);
            this.customerList.remove(username);
            this.customerList.put(username, editThis);
            log.info("User " + username + " now has authorization level " + BankSecurity.toString(auth) );
        } else {
            log.error("Attempt to edit non-existant user: " + username);
        }
    }
}
