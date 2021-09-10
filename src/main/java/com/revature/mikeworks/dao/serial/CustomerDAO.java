package com.revature.mikeworks.dao.serial;

import com.revature.mikeworks.components.Customer;

import java.io.*;
import java.util.HashMap;

public class CustomerDAO {
    public final String filePath = "./files/customers.txt";

    public HashMap<String, Customer> readCustomers() {
        HashMap<String, Customer> returnThis = new HashMap<String, Customer>();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fis);

            returnThis = (HashMap<String, Customer>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return returnThis;
    }

    public void writeCustomers(HashMap<String, Customer> input) {

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(input);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
