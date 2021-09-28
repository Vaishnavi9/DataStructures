package com.twoDarray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        //999999999999999999
//        int[] arr = {5,4,3,2,1};
//        int[] res = new int[arr.length];
//        int n = arr.length-1;
//
//        while ( n> 0){
//
//            if(arr[n-1] < arr[n]){
//                arr[n-1] = arr[n];
//                arr[n] = Integer.MAX_VALUE;
//
//            }
//            n--;
//        }
//
//
//        for (int i: arr){
//            if (i != Integer.MAX_VALUE) System.out.print(i+" ");
//        }
    }



//    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
//        ArrayList<Integer> reverseResult = new ArrayList<>();
//
//        for (Integer i : A) { // assuming list is of type List<Integer>
//            total = (10 * total ) + i;
// }


//        Collections.reverse(reverseResult);

//        return reverseResult;
//    }
    public static int count1bitFrom1toAandFindMod(int A) {
        long N = A + 1, mod = 1000*1000*1000 + 7;
        long ans = 0, pow2 = 1;
        for(int i = 0; i < 32; i++) {
            ans += ((N / (pow2 << 1)) * pow2)%mod + Math.max(0, N % (pow2 << 1) - pow2);
            ans %= mod;
            pow2 <<= 1;
        }
        return (int)ans;
    }
    public static int count1bitFrom1toAandFindMod2(int A) {
        long N = A + 1, mod = 1000*1000*1000 + 7;
        long ans = 0, pow2 = 1;
        for(int i = 0; i < 32; i++) {
            ans += ((N / (pow2 << 1)) * pow2) + Math.max(0, N % (pow2 << 1) - pow2);

            pow2 <<= 1;
        }

        return (int)ans;
    }
    public static int[][] generateMatrix(int A) {

        int result[][] = new int[A][A];
        int value = 1;
        int minRow = 0;
        int minCol = 0;
        int maxRow = A-1;
        int maxCol = A-1;
        int maxValue = A*A;

        while (value <= maxValue)
        {
            for (int i = minCol; i <= maxCol; i++)
            {
                result[minRow][i] = value;

                value++;
            }

            for (int i = minRow+1; i <= maxRow; i++)
            {
                result[i][maxCol] = value;

                value++;
            }

            for (int i = maxCol-1; i >= minCol; i--)
            {
                result[maxRow][i] = value;

                value++;
            }

            for (int i = maxRow-1; i >= minRow+1; i--)
            {
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



