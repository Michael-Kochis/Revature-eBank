package com.revature.mikeworks.drivers;

import com.revature.mikeworks.controllers.LoginRegisterMenuController;

public class BankDriver {
    private static LoginRegisterMenuController mc = new LoginRegisterMenuController();

    public static void runMain() {
        int input = mc.readOption();
        System.out.println(input);
    }
}
