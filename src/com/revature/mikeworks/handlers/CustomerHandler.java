package com.revature.mikeworks.handlers;

import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.dao.CustomerDAO;
import lombok.Getter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CustomerHandler implements Serializable {
    @Getter private HashMap<String, Customer> customerList;
    final static CustomerDAO dao = new CustomerDAO();

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
}
