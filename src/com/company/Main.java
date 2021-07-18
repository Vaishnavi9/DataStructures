package com.company;


public class Main {
    private final boolean flag = true;

    public Main() {
        (new Inner()).test();
    }

    public static void main(String[] args) {
        //int result = sumN(5);
       //System.out.println(result);

      //  print1toN(5);

        //tail recursive are better because we do not do anything once function returns.
        System.out.println(fact(5,1));
    }

    public static int sumN(int n) {
        if (n <= 1) {
            return 1;
        }

        return n + sumN(n - 1);
    }
    public static void print1toN(int n){
        if(n==0){
            return ;
        }

        print1toN(n-1);
        System.out.println(n);
    }

    public static int fact(int n,int k){
        if(n==0){
            return k;
        }

        return fact(n-1,n*k);

    }
    public void sample() {
        System.out.println("Sample");
    }

    class Inner {
        void test() {
            if (Main.this.flag) {
                sample();
            }
        }
    }
}

abstract class AbstractExample {
    public abstract int sum(int a, int b);

    public void print() {
        System.out.println("I am from abstract");
    }
}


