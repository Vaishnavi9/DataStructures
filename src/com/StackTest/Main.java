package com.StackTest;

public class Main {
    public static void main(String[] args) {
/*        int[] arr = {0,1,1,1,1,0,0,0};
        int start = 0;
        int end = arr.length-1;

        while (start <= end ){
            if (arr[start] == 1) {
                // swap
                arr[end] = arr[end]+ arr[start];
                arr[start] = arr[end]-arr[start];
                arr[end] = arr[end]-arr[start];
                end--;
            } else {
                start++;
            }
        }

        for (int i: arr ){
            System.out.print(i+" ");
        }*/

        String s = "123124";

        int x = Integer.parseInt(s.substring(0, (s.length() / 2)));
        System.out.println(x);
        int x1 = Integer.parseInt(s.substring(s.length() / 2));
        System.out.println(x1);
        if(x+1 == x1){
            System.out.println("yes");
        }

    }
}
