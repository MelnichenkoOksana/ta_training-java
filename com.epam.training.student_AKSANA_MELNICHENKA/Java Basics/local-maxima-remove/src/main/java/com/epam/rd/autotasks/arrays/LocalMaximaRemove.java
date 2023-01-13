package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){

        //put your code here
        int[] tempArray = new int[array.length];
        int count = 0;
        if (array.length>2){
            if (array[0] <= array[1]){
                tempArray[count] = array[0];
                count++;
            }
            for (int i = 1; i < array.length-1; i++) {
                if (array[i-1] >= array[i] || array[i] <= array[i+1]) {
                    tempArray[count] = array[i];
                    count++;
                }
            }
            if (array[array.length-2] >= array[array.length-1]){
                tempArray[count] = array[array.length-1];
                count++;
            }
        } else  if(array.length == 2){
            if (array[0] != array[1]){
                if (array[0] > array[1]){
                    tempArray[count] = array[1];
                    count++;
                } else {
                    tempArray[count] = array[0];
                    count++;
                }
            }

        } else {
            tempArray[count] = array[0];
            count++;
        }

        return Arrays.copyOf(tempArray, count);


//        throw new UnsupportedOperationException();

    }
}
