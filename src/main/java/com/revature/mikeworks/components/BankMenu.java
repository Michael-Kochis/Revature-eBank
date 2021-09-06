package com.revature.mikeworks.components;

import lombok.Getter;

public class BankMenu {
    @Getter private int size = 10;
    private String[] menuList;

    public BankMenu() {
        menuList = new String[size];

        for (int i = 0; i<size; i++) {
            this.menuList[i] = "";
        }
    }

    public void addMenuItem(int index, String item) {
        this.menuList[index] = item;
    }

    public void showMenu() {
        for (int index =0; index < size; index++) {
            String outString = this.menuList[index];
            if (outString != "")
                System.out.println(index + ": " + this.menuList[index]);
        }
    }

}
