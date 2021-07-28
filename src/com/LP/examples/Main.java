package com.LP.examples;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //int arr[] ={0,1,1,1,1,0,0,0};
        //System.out.println(findMaxConsecutiveOnes(arr));
        // System.out.println(findMaxConsecutiveOnesEffective(arr));
        //int largestK[] ={56,90,89,65,45};
        //System.out.println(kthLargestElement(largestK,2));

        int[] arr = {0, 1, 0, 4};
        duplicateZeroes(arr);
    }
    public static void duplicateZeroes(int[] arr){
        int zeroes = 0;
        for(int i: arr){
            if (i == 0) zeroes++;
        }

        int i = arr.length - 1, j = arr.length + zeroes - 1;

        while(i != j){
            insert(arr, i, j--);
            if(arr[i] == 0){
                insert(arr, i, j--);
            }
            i--;
        }

    }

    private static void insert(int[] arr, int i, int j){
        if(j < arr.length){
            arr[j] = arr[i];
        }
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0; //intitialize count
        int n=nums.length;
        int result = 0; //initialize max

        for (int i = 0; i < n; i++)
        {

            // Reset count when 0 is found
            if (nums[i] == 0)
                count = 0;

                // If 1 is found, increment count
                // and update result if count becomes
                // more.
            else
            {
                count++;//increase count
                result = Math.max(result, count);
            }
        }

        return result;
    }

    public static int findMaxConsecutiveOnesEffective(int[] nums) {
        //arraylist to hold consecutive ones
        ArrayList<Integer> consecutives = new ArrayList<Integer>();
        //var to hold streaks
        int streak = 0;
        //iterating through array
        for (int i = 0; i < nums.length; i++){

            if (nums[i] == 1){
                streak++;
            }
            else{
                consecutives.add(streak);
                streak = 0;
            }
        }
        consecutives.add(streak);
        Integer max = Collections.max(consecutives);
        return max;


    }

    public static int kthLargestElement(int[] arr, int k){
        int result;
        for(int j=0;j<arr.length-1;j++){
            if(arr[j]<arr[j+1]){
                int temp=arr[j+1];
                arr[j+1]=arr[j];
                arr[j]=temp;
                j=-1;
            }
        }

        result = arr[k-1];
        return result;
    }



}
