package com.Hashing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int[] input = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        longestConsecutive(input);
    }

    /* Problem Description
     Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
     If the answer does not exist return an array with a single element "-1".
     First sub-array means the sub-array for which starting index in minimum.
     Problem Constraints
             1 <= length of the array <= 100000
             1 <= A[i] <= 109
             1 <= B <= 109
     Input Format
     The first argument given is the integer array A.
     The second argument given is integer B.
     Output Format
     Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".
     Example Input
     Input 1: A = [1, 2, 3, 4, 5] B = 5
     Input 2: A = [5, 10, 20, 100, 105] B = 110
     Example Output
     Output 1: [2, 3]
     Output 2: -1
     Example Explanation
     Explanation 1: [2, 3] sums up to 5.
     Explanation 2: No subarray sums up to required number.*/
    public static int[] solve(int[] A, int B) {
        long n = A.length;
        int l = 0, r = 0;
        long sum = A[l];
        while (r < n) {
            if (sum == B) {
                int[] ans = new int[r - l + 1];
                for (int i = l; i <= r; i++) ans[i - l] = A[i];
                return ans;
            } else if (sum < B) {
                r++;
                if (r < n) sum += A[r];
            } else {
                sum -= A[l];
                l++;
                if (l > r && l < n - 1) {
                    r++;
                    sum += A[r];
                }
            }
        }
        int ans[] = new int[1];
        ans[0] = -1;
        return ans;
    }

    /*Given an unsorted integer array A of size N.
      Find the length of the longest set of consecutive elements from the array A.
      Problem Constraints 1 <= N <= 106 -106 <= A[i] <= 106
      Input Format - First argument is an integer array A of size N.
      Output Format - Return an integer denoting the length of the longest set of consecutive elements from the array A.
      Example Input Input 1: A = [100, 4, 200, 1, 3, 2]
      Input 2: A = [2, 1] Example Output Output 1: 4 Output 2: 2*/
    public static int longestConsecutive(final int[] A) {
        int temp = 0;
        int result = 0;
        Arrays.sort(A);
        if ( A.length == 1) return 1;
        for ( int i =0; i < A.length-1; i++ ){
            if (A[i] == A[i+1]){
                continue;}
            else if (A[i+1] == A[i]+1) {
                temp += 1;

            }
            else {
                result = Math.max(temp,result);
                temp = 0;
            }

        }

        if (temp > result) result = temp;


        return result > 0 ? result + 1: 0;
    }

    /*Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
    Example :
    Input :
    A : [1 5 3]
    k : 2
    Output :  1 as 3 - 1 = 2
    Return 0 / 1 for this problem.*/
    public int diffPossible(final int[] A, int B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j < A.length; j++) {
                if ((i != j) && (A[i] - A[j] == B)) {
                    return 1;
                }
            }
        }
        return 0;

    }
}
