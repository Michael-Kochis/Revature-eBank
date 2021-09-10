package com.revature.mikeworks.dao.interfaces;

import com.revature.mikeworks.components.Customer;

import java.util.HashMap;

public interface iCustomerDAO {
    public void deleteCustomer(Customer toDelete);
    public HashMap<String, Customer> readCustomers();
    public void updateCustomer(String username);
    public void writeCustomer(Customer input);
    }
