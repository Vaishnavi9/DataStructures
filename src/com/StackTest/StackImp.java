package com.StackTest;

import com.stack.Stack;

public class StackImp {
    static  int initialSize = 10;
    static int top ;
    int[] a = new int[initialSize];

    StackImp() {
        top = -1;
    }
     void push (int x){
        if (top == initialSize-1){
            int[] temp = new int[initialSize];
            for(int i =0; i < a.length; i++ ){
                temp[i] = a[i];
            }
            initialSize = initialSize + 10;
            a = new int[initialSize];
            for(int i =0; i < temp.length; i++ ){
                a[i] = temp[i];
            }

        }
        a[++top] = x;
    }

    int pop (){

         return a[top--];
    }




}
