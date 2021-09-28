package com.stack;

public class StackUsingNode {

    StackNode root;

    static class StackNode {
        int data;
        StackNode next;
        StackNode ( int data ) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        if ( root == null ) {
            return true;
        }
        return false;
    }

    public void push ( int data ){
        StackNode newNode = new StackNode( data );
        if ( isEmpty() ) {
            root = newNode;
        }
        else {
            StackNode temp = root;
            root = newNode;
            root.next = temp;
        }
    }


    public int pop() {
        if ( isEmpty() ) {
            return Integer.MIN_VALUE;
        }

        int data = root.data;
        root = root.next;
        return  data;
    }

    public int peek() {
        if ( isEmpty() ) {
            return Integer.MIN_VALUE;
        }
        return root.data;
    }
}
