package com.arrayProblemSetTwoImportant;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //subsequenceAG("GBA");
        ArrayList<Integer> input1 = new ArrayList<Integer>(){{
            add(12);
            add(1);
            add(11);
            add(0);
            add(10);
            add(6);
            add(5);
            add(12);
        }};

        minMaxSubArray(input1);
    }


    /*You have given a string A having Uppercase English letters.
      You have to find that how many times subsequence "AG" is there in the given string.
      NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
      Problem Constraints 1 <= length(A) <= 105
      Input Format First and only argument is a string A.
      Output Format Return an integer denoting the answer.
      Example Input
      Input 1: A = "ABCGAG" Output 1: 3
      Input 2: A = "GAB" Output 2: 0
      Example Explanation
      Explanation 1: Subsequence "AG" is 3 times in given string
      Explanation 2: There is no subsequence "AG" in the given string.*/

    public static int subsequenceAG(String A) {
        int answer = 0;
        int count = 0;

        for ( int i = A.length()-1; i >= 0; i--){
            if ( A.charAt(i) == 'G') { count++;}
            if (A.charAt(i) == 'A') {answer+=count;}
        }

        return answer;
    }

    /*Given an array A. Find the size of the smallest subarray such that it contains atleast one
      occurrence of the maximum value of the array and atleast one occurrence of the minimum value of the array.
      Problem Constraints 1 <= |A| <= 2000
      Input Format First and only argument is vector A
      Output Format
      Return the length of the smallest subarray which has atleast one occurrence of minimum and maximum element of the array
      Example Input
      Input 1: A = [1, 3] Output 1: 2
      Input 2: A = [2]
      Example Output Output 2: 1
    */

    public static int minMaxSubArray(ArrayList<Integer> A) {
        int min = A.get(0);
        int max = A.get(0);
        for ( int i=1; i < A.size(); i++) {
            if ( A.get(i) > max) max = A.get(i);
            if ( A.get(i) < min) min = A.get(i);
        }

        System.out.println(min+" "+max);

        return 0;
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
