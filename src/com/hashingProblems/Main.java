package com.hashingProblems;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, -2, -1};
        int[] ab = { 1,5,5,1,2,2 };

        System.out.println(checkFirstRepeatedOccurrenceType2(ab, ab.length));
/*        System.out.println(checkFirstRepeatedOccurrenceType1(ab, ab.length));
        System.out.println(checkIfSubArrayContainsSumZero(a, a.length));*/
    }


    //sub array with sum zero
    public static int checkIfSubArrayContainsSumZero(int[] A, int n){
        int result = 0;
        long sum = 0;
        Set<Long> set = new HashSet<>();
        for ( int i = 0; i < n; i++){
            sum += A[i];
            if ( sum == 0 || A[i] == 0 || set.contains(sum)){
                result = 1;
                break;
            }
            set.add(sum);
        }

        System.out.println(set);
        return result;
    }


    //check the first occurrence of a number in array {1,5,3,3,5,0}  result = 5
    public static int checkFirstRepeatedOccurrenceType1 (int[] a, int n){
        int index  = -1;
        Set<Integer> test = new LinkedHashSet<>();

        for ( int i = n-1; i >= 0; i-- ){
            if ( test.contains(a[i]) ) { index = i; break;}
            else { test.add(a[i]);}
        }
        System.out.println(test);
        return a[index];
    }

    //check the first occurrence of a number in array {1,5,3,1,3,5,0}  result = 1
    public static int checkFirstRepeatedOccurrenceType2 (int[] a, int n){
        int index  = -1;
        Set<Integer> test = new LinkedHashSet<>();

        for ( int i = 0; i < n-1; i++ ){
            if ( test.contains(a[i]) ) { index = i; break;}
            else { test.add(a[i]);}
        }
        System.out.println(test);
        return a[index];
    }


}
