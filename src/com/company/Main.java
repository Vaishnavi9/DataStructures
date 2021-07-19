package com.company;


public class Main {
    public static void main(String[] args) {
        //int result = sumN(5);
       //System.out.println(result);

      //  print1toN(5);

        //tail recursive are better because we do not do anything once function returns.
        //System.out.println(fact(5,1));
        //secondLargest();
        //reverseArray();
        removeDup();
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



public static void reverseArray(){
    int[] a={1,2,3,4,5};

    int start=0;
    int end= a.length-1;


    while(start<end){
        int temp=a[start];
        a[start]=a[end];
        a[end]=temp;
        end--;
        start++;
    }


    for(int i=0;i<a.length;i++){
        System.out.println(a[i]);
    }
}


public static void removeDup(){
    int[] h={2,3,4,4,5,6,6,6};
    int[] temp = new int[h.length];
    int res=1;
    temp[0]=h[0];

    for(int i=0;i<h.length;i++){
        if(temp[res-1]!=h[i]){
            temp[res]=h[i];
            res++;
        }
    }


    for(int i=0;i<res;i++){
        System.out.println(temp[i]);
    }
}
    }








