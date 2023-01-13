package com.epam.rd.autotasks.meetautocode;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();

        int resultHours = 0;
        int resultMinutes = 0;
        int resultSeconds = 0;

        while (seconds>0) {
            if (seconds < 59) {
                resultSeconds = seconds;
            } else if (seconds < 3600) {
                resultMinutes = (int) Math.floor(seconds / 60);
                resultSeconds = seconds - (resultMinutes * 60);
            } else if (seconds < 86400) {
                resultHours = (int) Math.floor(seconds / 3600);
                resultMinutes = (int) Math.floor((seconds - resultHours * 3600) / 60);
                resultSeconds = seconds - (resultMinutes * 60) - (resultHours * 3600);
            }
            seconds = seconds - 86400;
        }

        System.out.println(resultHours +":"+ new DecimalFormat( "00" ).format(resultMinutes) +":"+ new DecimalFormat( "00" ).format(resultSeconds));



    }
}
