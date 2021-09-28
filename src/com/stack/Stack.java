package com.stack;

public class Stack {

    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX];

    boolean isEmpty(){
        return top < 0;
    }

    Stack () {
        top = -1;
    }

    boolean push(int x){
        boolean isPushed = false;
        if (top >= MAX){
            System.out.println("Stack over flow");
        }
        else {
            a [++top] = x;
            isPushed = true;
        }
        return isPushed;
    }

    int pop(){
        if ( isEmpty() ){
            System.out.println("No elements in stack");
            return 0;
        }
        else {
            int x = a [top--];
            return x;
        }
    }

    int peek(){
        if ( isEmpty() ){
            System.out.println("No elements in stack");
            return 0;
        }
        else {
            int x = a[top];
            return x;
        }
    }
}
