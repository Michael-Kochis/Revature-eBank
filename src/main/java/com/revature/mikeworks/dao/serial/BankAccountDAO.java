package com.revature.mikeworks.dao.serial;

import com.revature.mikeworks.components.BankAccount;

import java.io.*;
import java.util.HashMap;

public class BankAccountDAO {
    public final String filePath = "./files/accounts.txt";

    public HashMap<Long, BankAccount> readAccounts() {
        HashMap<Long, BankAccount> returnThis = new HashMap<Long, BankAccount>();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fis);

            returnThis = (HashMap<Long, BankAccount>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return returnThis;
    }

    public void writeAccounts(HashMap<Long, BankAccount> input) {

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
