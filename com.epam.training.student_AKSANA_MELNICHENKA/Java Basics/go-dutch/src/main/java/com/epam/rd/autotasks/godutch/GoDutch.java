package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        Scanner scanner = new Scanner(System.in);
        int bill = scanner.nextInt();
        int friends = scanner.nextInt();

        if (friends > 0 && bill >= 0){
            int result = (int)Math.round(((double)bill/(double) friends)*1.1);
            System.out.println(result);
        } else if (friends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            System.out.println("Bill total amount cannot be negative");
        }

    }
}
