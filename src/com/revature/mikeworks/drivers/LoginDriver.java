package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.handlers.CustomerHandler;
import com.revature.mikeworks.utils.ValidScanner;

public class LoginDriver {
    private static boolean looping;
    private static String username, password;
    private static final ValidScanner scan = new ValidScanner();
    private static CustomerHandler cHandler = BankData.getCHandler();
    private static final BankUserDriver bud = new BankUserDriver();

    public void attemptLogin(String uname, String pass) {
        if (cHandler.canLogIn(uname, pass)) {
            Customer loggedIn = cHandler.getCustomerByUsername(username);
            BankData.setWhoAmI(loggedIn);
            System.out.println(BankData.getWhoAmI());
            bud.doMain();
            looping = false;
        }
    }

    public void runLoginDriver() {
        looping = true;
        while (looping) {
            System.out.println("Enter your username");
            this.username = scan.readString();
            if (username.equals("0")) {
                looping = false;
            } else if (!cHandler.contains(this.username)) {
                System.out.println("Pick a valid username, or enter 0 to go back");
                continue;
            }
            System.out.println("Enter your password");
            this.password = scan.readString();

            attemptLogin(username, password);
        }

    }
}
