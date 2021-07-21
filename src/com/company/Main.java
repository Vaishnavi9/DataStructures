package com.company;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //int result = sumN(5);
       //System.out.println(result);

      //  print1toN(5);

        //tail recursive are better because we do not do anything once function returns.
        //System.out.println(fact(5,1));
        //secondLargest();
        //reverseArray();
        //removeDup();
        //leftRotateByD();
        //sortWithSingleLoop();
        binarySearchIterative();
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

    int res=1;


    for(int i=0;i<h.length;i++){
        if(h[res-1]!=h[i]){
            h[res]=h[i];
            res++;
        }
    }


    for(int i=0;i<res;i++){
        System.out.println(h[i]);
    }

}

public static void moveZerosToEndNaive(){
    int[] h={3,0,3,0,9,0};

    int result=0;


    label: for(int i=0;i<h.length;i++){
        if(h[i]==0){
            inner: for(int j=i+1;j<h.length;j++){
                if(h[j]!=0){
                    int temp=h[i];
                    h[i]=h[j];
                    h[j]=temp;
                    break inner;
                }

            }
        }
    }


    for(int i=0;i<h.length;i++){
        System.out.println(h[i]);
    }
}

public static void moveZeroesToEndSingleLoop(){
    int[] h={3,0,9,0};
    int count=0;
    for(int i=0;i<h.length;i++){
        if(h[i]!=0){
            int temp=h[i];
            h[i]=h[count];
            h[count]=temp;
            count++;
        }
    }


    for(int i=0;i<h.length;i++){
        System.out.println(h[i]);
    }
}


public static void leftRotateArrayByOne(){
    int[] h={1,2,3,4};

    int temp=h[0];
    int n= h.length;

    for(int i=1;i<n;i++){
        h[i-1]=h[i];
    }

    h[n-1]=temp;

    System.out.println(" ");
    for(int i=0;i<n;i++){
        System.out.print(h[i]+" ");
    }
}

public static void leftRotateByD(){
        int[] arr={2,3,5,6,7};
        int d=2;
        int n= arr.length;
        int temp[]= new int[d];
        for(int i=0;i<d;i++){
            temp[i]=arr[i];
        }
       for(int i=d;i<n;i++){
           arr[i-d]=arr[i];
       }
       for(int i=0;i<d;i++){
           arr[n-d+i]=temp[i];
       }

    for(int i=0;i<arr.length;i++){
        System.out.println(arr[i]);
    }
}

public static void sortWithSingleLoop(){
        int arr[]={2,51,21,3};
    for (int j = 0; j < arr.length - 1; j++) {

        // Type Conversion of char to int.
        int d1 = arr[j];
        int d2 = arr[j + 1];

        // Comparing the ascii code.
        if (d1 > d2) {

            // Swapping of the characters
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            j = -1;
        }
    }

    for(int i=0;i<arr.length;i++){
        System.out.println(arr[i]);
    }
}


public static void binarySearchIterative(){
    int arr[]={40,0};
    int n=21;
    int start=0;
    int end=arr.length-1;
    int result=0;
    while(start<=end){
        int mid =(start+end)/2;
        if(arr[mid]==n){
            result=mid;
            break;
        }
        else if(arr[mid]>n){
            end=mid-1;
        }
        else if(arr[mid]<n){
            start=mid+1;
        }
    }

    System.out.println(arr[result]+" "+result);
}
}










