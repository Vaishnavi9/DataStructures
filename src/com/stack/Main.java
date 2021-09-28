package com.stack;

public class Main {

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push( 20 );
        s.push( 25 );
        s.push( 21 );

        //System.out.println( s.pop() );
        //System.out.println( s.peek() );

        StackUsingNode sul = new StackUsingNode();
        sul.push( 25 );
        sul.push( 20 );
        sul.push( 21 );
        sul.push( 26 );
        System.out.println( sul.peek() );
        System.out.println( sul.pop() );
        System.out.println( sul.peek() );
    }
}
