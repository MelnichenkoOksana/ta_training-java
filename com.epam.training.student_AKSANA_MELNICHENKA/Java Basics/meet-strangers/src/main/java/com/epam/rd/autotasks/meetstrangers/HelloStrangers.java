package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();

        if (amount>0) {
            for (int i = 0; i < amount; i++) {
                Scanner in = new Scanner(System.in);
                String name = in.nextLine();
                System.out.println("Hello, " + name);
            }
        } else if (amount == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else {
            System.out.println("Seriously? Why so negative?");
        }
    }
}
