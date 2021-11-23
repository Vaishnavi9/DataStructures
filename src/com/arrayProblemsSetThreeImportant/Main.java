package com.arrayProblemsSetThreeImportant;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String A = "010100110101";
        consecutiveOnes(A);
    }


    public static int consecutiveOnes(String A) {
        int cnt_one = 0;
        int n=A.length();
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1')
                cnt_one++;
        }

        // To store cumulative 1's
        int[] left = new int[n];
        int[] right = new int[n];

        if (A.charAt(0) == '1')
            left[0] = 1;
        else
            left[0] = 0;

        if (A.charAt(n-1) == '1')
            right[n - 1] = 1;
        else
            right[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            if (A.charAt(i) == '1')
                left[i] = left[i - 1] + 1;
            else
                left[i] = 0;
        }
        for (int i: left) System.out.print(i+" ");
        System.out.println();
        for (int i = n - 2; i >= 0; i--) {
            if (A.charAt(i) == '1')
                right[i] = right[i + 1] + 1;

            else
                right[i] = 0;
        }
        for (int i: right) System.out.print(i+" ");
        System.out.println();
        int cnt = 0, max_cnt = 0;
        for(int i=0; i<n; ++i )
            max_cnt=Math.max(max_cnt,Math.max(right[i],left[i]));
        for (int i = 1; i < n - 1; i++) {
            if (A.charAt(i) == '0') {
                int sum = left[i - 1] + right[i + 1];

                if (sum < cnt_one)
                    cnt = sum + 1;

                else
                    cnt = sum;

                max_cnt = Math.max(max_cnt, cnt);
                cnt = 0;
            }
        }

        System.out.println(max_cnt);

        return max_cnt;
    }

    public static int maxOnes(ArrayList<ArrayList<Integer>> input){


        int max = -1;
        int result = -1;
        for ( int i = 0; i < input.size(); i++ ) {
            for ( int j = 0; j < input.get(i).size(); j++ ){
                if (input.get(i).get(j) == 1) {
                    int sum = input.get(i).size() - j;
                    if ( sum > max) {
                        max = sum;
                        if ( ( result == -1) || (result < i)) result = i;

                    }
                }
            }


        }
        //System.out.println(result);

        return result;
    }

    public static int[][] generateSpiralMatrix(int A) {
        int[][] result = new int[A][A];

        int start = 1;
        int end = A * A;
        int startRow = 0;
        int endRow = A - 1;
        int startCol = 0;
        int endCol = A - 1;
        while (start <= end) {
            for (int i = startCol; i < endRow && start <= end; i++) {
                result[startCol][i] = start;
                start++;
            }
            for (int i = startRow; i <= endCol && start <= end; i++) {
                result[i][endCol] = start;
                start++;
            }
            for (int i = endCol - 1; i >= startRow && start <= end; i--) {
                result[endRow][i] = start;
                start++;
            }
            for (int i = endRow - 1; i > startRow && start <= end; i--) {
                result[i][startRow] = start;
                start++;
            }

            startRow++;
            startCol++;
            endCol--;
            endRow--;

        }

       for ( int i = 0; i < result.length; i++ ) {
            for ( int j = 0; j < result[0].length; j++ ){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

        return result;
    }



    public static int findBin2DSortedMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int result = -1;

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                int temp = ((i + 1) * 1009) + (j + 1);
                if ((A.get(i).get(j) == B) && ((result == -1) || temp < result)) result = temp;
            }
        }
        return result;
    }


}
