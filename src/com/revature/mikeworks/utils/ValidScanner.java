package com.revature.mikeworks.utils;

import java.util.Scanner;

public class ValidScanner {
    private final static Scanner scan = new Scanner(System.in);

    public int readInt() {
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                return scan.nextInt();
            } else {
                System.out.println("Integer input expected:");
                scan.nextLine();
            }
        }
        return -1;
    }

    public double readDouble() {
        while (scan.hasNext()) {
            if (scan.hasNextDouble()) {
                return scan.nextDouble();
            } else {
                System.out.println("Double input expected:");
                scan.nextLine();
            }
        }
        return -1;
    }

    public String readString() {
        return scan.next();
    }
}
