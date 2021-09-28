package com.hashingProblems;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 1};
        int[] b = { 1,1,2 };
        ArrayList<Integer> aa = new ArrayList<Integer>(){{
            add(2); add(1); add(4); add(10); add(10); }};
        ArrayList<Integer> bb = new ArrayList<Integer>(){{
            add(3); add(6); add(2); add(10); add(10); add(1);}};
       ArrayList<Integer> result = checkCommonElementsInTwoArrays(aa,bb);
        for (int i: result) {
            System.out.print(i+" ");
        }
        //System.out.println(checkFirstRepeatedOccurrenceType2(ab, ab.length));
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


    //check common elements in 2 arrays
    public static ArrayList<Integer> checkCommonElementsInTwoArrays(ArrayList<Integer> a, ArrayList<Integer> b){
         ArrayList<Integer> result = new ArrayList<>();
         Map<Integer, Integer> f = new HashMap<>();

         for (Integer i : a) {
             if (f.containsKey(i)) {
                 f.put(i, f.get(i)+1);
             }
             else
             {
                 f.put(i,1);
             }

         }


         for (int i = 0; i < b.size(); i++){
             if (f.containsKey(b.get(i)) && f.get(b.get(i)) > 0 ) {
                 result.add(b.get(i));
                 f.put(b.get(i), f.get(b.get(i)) - 1);
             }
         }
         return result;
    }


}
