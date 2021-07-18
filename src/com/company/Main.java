package com.company;


public class Main {
    public static void main(String[] args) {
        //int result = sumN(5);
       //System.out.println(result);

      //  print1toN(5);

        //tail recursive are better because we do not do anything once function returns.
        System.out.println(fact(5,1));
        secondLargest();
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


public static void secondLargest(){
        int[] test;

                test = new int[]{78,1089,1,4,900};



              int r=-1,largest=0;
              int index=0;
              for(int i=1;i<test.length;i++){
                  if(test[i]>test[largest]){
                      r=largest;
                      largest=i;

                  }
                  else if(test[i]!=test[largest]){
                      if(r==-1 || test[i]>test[r]){
                          index= i;
                      }
                  }
              }

              System.out.println(test[index]);
}
    }








