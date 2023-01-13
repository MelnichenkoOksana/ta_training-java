package com.epam.rd.autotasks;

import java.math.BigInteger;
import org.apache.maven.shared.utils.StringUtils;


public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        String[] mapShips = getMapArray(ships);
        String[] mapShots = getMapArray(shots);

        int numberInMap = getNumberInMap(shot);
        mapShots[numberInMap] = "1";

        StringBuilder temp = new StringBuilder();
        for (String el:
             mapShots) {
            temp.append(el);
        }

        BigInteger shotsBig= new BigInteger(temp.toString(),2);
        shots= shotsBig.longValue();

        return mapShips[numberInMap].equals("1");
    }

    public int getNumberInMap (String shot) {
        String [] temp  = shot.split("");
        int letterNum = 0;
        switch (temp[0]){
            case "A": letterNum = 0;
                break;
            case "B": letterNum = 1;
                break;
            case "C": letterNum = 2;
                break;
            case "D": letterNum = 3;
                break;
            case "E": letterNum = 4;
                break;
            case "F": letterNum = 5;
                break;
            case "G": letterNum = 6;
                break;
            case "H": letterNum = 7;
                break;
        }
        return ((Integer.parseInt(temp[1])-1)*8+letterNum);
    }

    public String state() {
        String[] mapShips = getMapArray(ships);
        String[] mapShots = getMapArray(shots);

        StringBuilder result = new StringBuilder();


        for (int i = 0; i <mapShips.length ; i++) {
            if (i % 8 == 0) result.append('\n');

            if ((mapShips[i].equals("0")) && (mapShots[i].equals("0"))) result.append('.');
            else if ((mapShips[i].equals("0")) && (mapShots[i].equals("1"))) result.append('×');
            else if ((mapShips[i].equals("1")) && (mapShots[i].equals("0"))) result.append('☐');
            else if ((mapShips[i].equals("1")) && (mapShots[i].equals("1"))) result.append('☒');
        }

        return result.toString();
    }

    private static String[] getMapArray(long value){

        String dataString = Long.toBinaryString(value);
        String[] dataArray = dataString.split("");
        String[] temp = new String[64];
        System.arraycopy(dataArray, 0, temp, temp.length - dataArray.length, dataArray.length);
        for (int i = 0; i < 64; i++) {
            if (temp[i] == null) temp[i] = "0";
        }

        return StringUtils.join(temp, "").split("");
    }

}
