package com.array1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
//        int start = 0;
//        int end = arr.length-1;
//        //reversal(arr, start, end);
//        negativePartition(arr);
//        for (int i : arr) {
//            System.out.print(i+" ");
//        }
        //Find the missing elements from sorted list
        List<Integer> lst = Arrays.asList(1,2,3,4,5,6,8);
        int i = 0;
//        while(i++ < lst.size()-1){
//            if (lst.get(i+1) != lst.get(i)+1) {
//                System.out.println(lst.get(i)+1);
//                break;
//            }
//        }
        String s1 = "abc";
        String s2 = "xyz";

        s1 = s1+s2;
        s2 = s1.substring(0,s1.length()-s2.length());
        s1 = s1.substring(s2.length());

        System.out.println(s1+"\n"+s2);


    }

    public static void negativePartition(int[] arr){
        int start = 0;
        int mid = 0;
        int end = arr.length -1;
        int pivot = 0;
        while (mid <= end){
            if(arr[mid]< pivot){
                swap(arr, start++, mid++);

            }
            else if (arr[mid] > pivot){
                swap(arr,mid,end--);
            }
            else{
                mid++;
            }
        }
    }

    //dutch flag problem
    public static void sort012(int a[], int n)
    {
        int start = 0, mid =0;
        int pivot = 1;
        int end = a.length - 1;

        while ( mid<=end ){
            if (a[mid] < pivot){
                swap(a, start, mid);
                ++start;
                ++mid;
            }
            else if (a[mid] > pivot) {
                swap(a, mid, end);
                --end;
            }
            else {
                ++mid;
            }
        }

    }

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;

    }
    public static  void reversal(int[] arr, int start, int end){
        if (start >= end ){
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reversal(arr, start+1, end-1);
    }
}
