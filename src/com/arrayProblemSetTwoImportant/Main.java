package com.arrayProblemSetTwoImportant;

public class Main {
    public static void main(String[] args) {

    }

    /* You are given a n x n 2D matrix A representing an image.
       Rotate the image by 90 degrees (clockwise).
       You need to do this in place.
       Input: [ [1, 2], [3, 4] ] Output: [ [3, 1], [4, 2]]
     */
    public static void rotate90Degree(int[][] a) {
        int l = a.length;
        for (int i = 0; i < l / 2; i++) {
            for (int j = i; j < l - i - 1; j++) {

                int temp = a[i][j];
                a[i][j] = a[l - 1 - j][i];
                a[l - 1 - j][i] = a[l - 1 - i][l - 1 - j];
                a[l - 1 - i][l - 1 - j] = a[j][l - 1 - i];
                a[j][l - 1 - i] = temp;
            }
        }
    }

    //Spiral Order Matrix II -> i/p 2 o/p -> [ [1, 2], [4, 3] ]
    public static int[][] generateMatrix(int A) {

        int result[][] = new int[A][A];
        int value = 1;
        int minRow = 0;
        int minCol = 0;
        int maxRow = A - 1;
        int maxCol = A - 1;
        int maxValue = A * A;

        while (value <= maxValue) {
            for (int i = minCol; i <= maxCol; i++) {
                result[minRow][i] = value;
                value++;
            }

            for (int i = minRow + 1; i <= maxRow; i++) {
                result[i][maxCol] = value;
                value++;
            }

            for (int i = maxCol - 1; i >= minCol; i--) {
                result[maxRow][i] = value;
                value++;
            }

            for (int i = maxRow - 1; i >= minRow + 1; i--) {
                result[i][minCol] = value;
                value++;
            }
            minCol++;
            minRow++;
            maxCol--;
            maxRow--;
        }
        return result;
    }


    

}
