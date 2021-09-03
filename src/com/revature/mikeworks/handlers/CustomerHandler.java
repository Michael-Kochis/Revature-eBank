package com.revature.mikeworks.handlers;

import com.revature.mikeworks.components.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class CustomerHandler {
    @Getter private HashMap<String, Customer> customerList;

    public CustomerHandler() {
        this.customerList = new HashMap<String, Customer>();
    }

    public void add(Customer neoCust) {
        if (this.contains(neoCust)) {
            System.out.println("Duplicate user cannot be added: " + neoCust);
        } else {
            this.customerList.put(neoCust.getUsername(), neoCust);
        }
    }

    public boolean contains(Customer neoCust) {
        return this.customerList.containsKey(neoCust.getUsername());
    }

    public int size() {
        return this.customerList.size();
    }
}
