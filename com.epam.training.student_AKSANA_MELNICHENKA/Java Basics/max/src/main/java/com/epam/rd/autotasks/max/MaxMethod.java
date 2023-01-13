package com.epam.rd.autotasks.max;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMethod {
    public static int max(int[] values) {
//        throw new UnsupportedOperationException();
        Arrays.sort(values);
        return values[values.length-1];
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        String stringArray[] = data.split(" ");

        int[] values = new int[stringArray.length];
        for (int i = 0; i <stringArray.length ; i++) {
            values[i] = Integer.parseInt(stringArray[i]);
        }

        System.out.println(max(values));
    }

}
