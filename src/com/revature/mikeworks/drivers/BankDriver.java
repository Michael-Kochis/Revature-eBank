package com.revature.mikeworks.drivers;

import com.revature.mikeworks.controllers.LoginRegisterMenuController;
import com.revature.mikeworks.handlers.CustomerHandler;

public class BankDriver {
    private static boolean looping = true;
    private static final LoginRegisterMenuController mc = new LoginRegisterMenuController();
    private static final LoginDriver ld = new LoginDriver();
    private static final RegisterDriver rd = new RegisterDriver();
    public static final CustomerHandler cHandler = new CustomerHandler();

    private static void setup() {
        cHandler.loadAll();
    }

    private static void teardown() {
        cHandler.saveAll();
    }

    private static void mainStep(int next) {
        switch (next) {
            case (1) -> ld.runLoginDriver();
            case (2) -> rd.runRegisterDriver(cHandler);
            default -> {
                looping = false;
            }
        }
    }
    public static void runMain() {
        int input;

        setup();
        while (looping) {
            input = mc.readOption();
            BankDriver.mainStep(input);
        }
        System.out.println(cHandler);
        teardown();
    }
}
