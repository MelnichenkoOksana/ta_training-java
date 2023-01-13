package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Use Scanner methods to read input
        int num = scanner.nextInt();
        int summa = 0;
        int amount = 0;

        while (num != 0) {
            summa = summa + num;
            amount++;
            num = scanner.nextInt();
        }

        System.out.println((int)(summa / amount));

    }

}