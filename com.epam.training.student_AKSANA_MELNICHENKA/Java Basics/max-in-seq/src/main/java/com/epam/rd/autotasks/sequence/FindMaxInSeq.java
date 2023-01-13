package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        // Put your code here

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int max = num;

        while (num != 0) {
            if (max < num) max = num;
            num = scanner.nextInt();
        }

        return max;
    }

    public static void main(String[] args) {

//        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
