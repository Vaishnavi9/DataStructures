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
       //ArrayList<Integer> result = checkCommonElementsInTwoArrays(aa,bb);

        //System.out.println(checkFirstRepeatedOccurrenceType2(ab, ab.length));
/*        System.out.println(checkFirstRepeatedOccurrenceType1(ab, ab.length));
        System.out.println(checkIfSubArrayContainsSumZero(a, a.length));*/

        ArrayList<Integer> t = new ArrayList<Integer>(){{add(1); add(2); add(3);}};
        //System.out.println(addOneToNumber(t));

        int[] inputPrefixSum =  { 1, 2, 3, 4, 5, 6, 7 };
        int[][] query = { {0,3} , {2,5}, {3,6}};

prefixMethod(inputPrefixSum, query);

    }

    //query the sum of data in given range from array
    public static void prefixMethod ( int[] input, int[][] query ) {
        int prefix[] = new int[ input.length];
        int[] result = new int [query.length ];
        int sum = 0;

        for ( int i=0; i < input.length; i++ ) {
            sum += input[i];
            prefix[i] = sum;
        }

        for ( int i = 0; i < query.length; i++ ) {
            int left = query[i][0];
            int right = query[i][1];
            result[i] = prefix[right] - prefix[left] + input[left];
        }

        for ( int i: result) System.out.print(i+" ");
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

    //consider elements of an array as 1 digit and add 1 to it
    public static ArrayList<Integer> addOneToNumber ( ArrayList<Integer> input ) {
        int carry = 0;
        if ( input.size() > 0) {
            for ( int i = 0; i < input.size(); i ++){
                if (input.get(0) == 0) {
                    input.remove(0);
                }
                else break;
            }
        }

        if ( input.size() == 0) return new ArrayList<Integer>(){{add(1);}};

       int n = input.size() - 1;
       while ( n >= 0 ){
           if ( input.get(n) == 9) {
               input.set(n,0);
               n--;
               carry = 1;
           }
           else {
               input.set(n, input.get(n)+1);
               return input;
           }
       }
           if ( carry == 1 && input.get(0)==0){
               input.set(0,1);
               input.add(0);
           }
           return input;
    }


}
