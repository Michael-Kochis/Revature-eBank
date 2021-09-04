package com.revature.mikeworks.drivers;

import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.controllers.RegisterMenuController;
import com.revature.mikeworks.handlers.CustomerHandler;
import com.revature.mikeworks.utils.ValidScanner;

import java.util.Objects;

public class RegisterDriver {
    private static boolean looping;
    private static final RegisterMenuController menu = new RegisterMenuController();
    private static Customer registerMe = new Customer();
    private static CustomerHandler ch;
    private static final ValidScanner scan = new ValidScanner();
    
    public void runRegisterDriver(CustomerHandler ch) {
        RegisterDriver.ch = ch;
        int input;
        looping = true;

        while (looping) {
            System.out.println(registerMe);
            System.out.println();
            input = menu.readOption();
            RegisterDriver.mainStep(input);
        }
    }

    private static void mainStep(int input) {
        switch (input) {
            case (1) -> processUserName();
            case (2) -> processUserPassword();
            case (3) -> processFirstName();
            case (4) -> processLastName();
            case (5) -> processEmail();
            case (6) -> processRegister();
            default -> looping = false;
        }
    }

    private static void processUserName() {
        System.out.println("What username do you want?");
        String neoUserName = scan.readString();
        if (ch.contains(neoUserName)) {
            System.out.println("That username is taken, select another.");
        } else if (Objects.equals(neoUserName, "") || neoUserName.length() < 3) {
            System.out.println("Enter a valid username, three character minimum");
        } else {
            registerMe.setUsername(neoUserName);
        }
    }

    private static void processUserPassword() {
        System.out.println("What password do you want?");
        String neoPass = scan.readString();
        registerMe.setPassword(neoPass);
    }

    private static void processFirstName() {
        System.out.println("Please enter your first name: ");
        String neoFirst = scan.readString();
        registerMe.setFirstName(neoFirst);
    }

    private static void processLastName() {
        System.out.println("Please enter your last name:");
        String neoLast = scan.readString();
        registerMe.setLastName(neoLast);
    }

    private static void processEmail() {
        System.out.println("What is your email?");
        String neoEmail = scan.readString();
        registerMe.setEmail(neoEmail);
    }

    private static void processRegister() {
        if (validRegisterMe()) {
            ch.add(registerMe);
            registerMe = new Customer();
        } else {
            System.out.println("All users need username, password, first and last name.");
            System.out.println("Email is optional.");
        }
    }

    private static boolean validRegisterMe() {
        return (!Objects.equals(registerMe.getUsername(), ""))
                && (registerMe.getUsername().length() >= 3)
                && (!Objects.equals(registerMe.getPassword(), ""))
                && (!Objects.equals(registerMe.getFirstName(), ""))
                && (!Objects.equals(registerMe.getLastName(), ""));
    }
}
