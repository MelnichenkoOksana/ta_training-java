package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {

        int num = 1;
        int[][] array = new int[rows][columns];

        if (rows > 1 && columns > 1){

            for (int y = 0; y < columns; y++) {
                array[0][y] = num;
                num++;
            }
            for (int x = 1; x < rows; x++) {
                array[x][columns - 1] = num;
                num++;
            }
            for (int y = columns - 2; y >= 0; y--) {
                array[rows - 1][y] = num;
                num++;
            }
            for (int x = rows - 2; x > 0; x--) {
                array[x][0] = num;
                num++;
            }

            int c = 1;
            int d = 1;

            while ( num< rows * columns) {
                while (array[c][d + 1] == 0) {
                    array[c][d] = num;
                    num++;
                    d++;
                }

                while (array[c + 1][d] == 0) {
                    array[c][d] = num;
                    num++;
                    c++;
                }

                while (array[c][d - 1] == 0) {
                    array[c][d] = num;
                    num++;
                    d--;
                }

                while (array[c - 1][d] == 0) {
                    array[c][d] = num;
                    num++;
                    c--;
                }
            }

            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < columns; y++) {
                    if (array[x][y] == 0) {
                        array[x][y] = num;
                    }
                }
            }

        } else {
            for (int y = 0; y < columns; y++) {
                for (int x = 0; x < rows; x++) {
                    array[x][y] = num;
                    num++;
                }
            }
        }

        return array;
    }
}
