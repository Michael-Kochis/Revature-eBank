package com.revature.mikeworks.components;

import com.revature.mikeworks.enums.BankSecurity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BankMenuAuth {
    private int size;
    private BankMenuAuthItem[] menuItems;

    public BankMenuAuth() {
        size = 10;
        menuItems = new BankMenuAuthItem[size];
    }

    public int size() {
        return this.size;
    }

    @AllArgsConstructor @NoArgsConstructor
    class BankMenuAuthItem {
        @Getter @Setter private int itemNumber;
        @Getter @Setter private String itemText;
        @Getter @Setter private BankSecurity itemAuth;
    }

    public void addMenuItem(int index, String text) {
        addMenuItem(index, text, BankSecurity.CUSTOMER);
    }

    public void addMenuItem(int index, String text, BankSecurity bs) {
        BankMenuAuthItem bma = new BankMenuAuthItem(index, text, bs);
        this.menuItems[index] = bma;
    }

    public void resize(int newSize) {
        BankMenuAuthItem[] neoMenu = new BankMenuAuthItem[newSize];
        for (int i = 0; i < size; i++) {
            neoMenu[i] = this.menuItems[i];
        }
        this.size = newSize;
        this.menuItems = neoMenu;
    }

    public void showMenu(BankSecurity auth) {
        for (int index =0; index < size; index++) {
            if ((this.menuItems[index] != null) &&
                    BankSecurity.authEqualOrGreater(this.menuItems[index].getItemAuth(), auth)) {
                String outString = this.menuItems[index].getItemText();
                if (outString != "")
                    System.out.println(index + ": " + outString);
            }
        }
    }

}
