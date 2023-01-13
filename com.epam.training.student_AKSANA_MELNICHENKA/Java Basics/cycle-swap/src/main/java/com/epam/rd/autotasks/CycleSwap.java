package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    public static void main(String[] args) {
        int[] array = new int[]{ 1, 3, 2, 7, 4 };
        CycleSwap.cycleSwap(array, 3);
        System.out.println(Arrays.toString(array));
    }


    static void cycleSwap(int[] array) {
        int[] tempArray = Arrays.copyOf(array, array.length);

        if (array.length > 1){
            System.arraycopy(tempArray, 0, array, 1, tempArray.length-1);
            System.arraycopy(tempArray, tempArray.length-1, array, 0, 1);
        }

    }

    static void cycleSwap(int[] array, int shift) {

        if (shift > array.length && array.length !=0) {
            while (shift > array.length) shift = shift- array.length;
        }

        int[] tempArray = Arrays.copyOf(array, array.length);

        if (array.length > 1){
            System.arraycopy(tempArray, 0, array, shift, tempArray.length-shift);
            System.arraycopy(tempArray, tempArray.length-shift, array, 0, shift);
        }

    }
}
