package com.Hashing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final int[] input = {1, 2, 1, 3, 4, 3};
        //longestConsecutive(input);
        dNums(input, 3);
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
        int[] ans = new int[1];
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
        if (A.length == 1) return 1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                continue;
            } else if (A[i + 1] == A[i] + 1) {
                temp += 1;

            } else {
                result = Math.max(temp, result);
                temp = 0;
            }

        }

        if (temp > result) result = temp;


        return result > 0 ? result + 1 : 0;
    }

    /*Problem Description
      You are given an array of N integers, A1, A2 ,…, AN and an integer B.
      Return the of count of distinct numbers in all windows of size B.
      Formally, return an array of size N-B+1 where i'th element in this array
      contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
      NOTE: if B > N, return an empty array.
      Input Format
      First argument is an integer array A Second argument is an integer B.
      Output Format Return an integer array.
      Example Input Input 1: A = [1, 2, 1, 3, 4, 3] B = 3
      Input 2: A = [1, 1, 2, 2] B = 1
      Example Output Output 1: [2, 3, 3, 2]
      Output 2: [1, 1, 1, 1]
      Example Explanation Explanation 1: A=[1, 2, 1, 3, 4, 3] and B = 3
      All windows of size B are [1, 2, 1] [2, 1, 3] [1, 3, 4] [3, 4, 3]
      So, we return an array [2, 3, 3, 2].
      Explanation 2: Window size is 1, so the output array is [1, 1, 1, 1].*/
    public static int[] dNums(int[] A, int B) {
        //1, 2, 1, 3, 4, 3
        //Arrays.sort(A);
        if (A.length == 1) return A;
        if (B == 1) {
            int[] re = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                re[i] = 1;
            }
            return re;
        }
        if (B == A.length) {
            Set<Integer> s = new HashSet<>();
            for (int i = 0; i < A.length; i++) {
                s.add(A[i]);
            }
            int[] re = new int[1];
            re[0] = s.size();
            return re;
        }
        Set<Integer> tmp = new HashSet<>();
      for(int i =0; i<A.length; i++){
          tmp.add(Integer.valueOf(A[i]));
      }
       if (tmp.size() == 1) {
           int[] re = new int[B+1];
           Arrays.fill(re,1);
           return re;
       }
       if(tmp.size()==1) {
           int[] re = new int[B+1];
           Arrays.fill(re,1);
           return re;
       }

        int[] res = new int[A.length];
        int tempIndex = 0;
        int i = 0;
        if (B<=A.length){
            while (i <= B) {
                Set s = new HashSet();
                if (i + B - 1 < A.length) {
                    for (int j = i; j < i + B; j++) {

                        s.add(A[j]);

                    }

                }

                res[tempIndex++] = s.size();
                i++;
            }
        }


        ArrayList<Integer> k = new ArrayList<>();
        for (int o : res) {
            if (o != 0) k.add(o);
        }
        int[] finalRes = new int[k.size()];
        int u = 0;
        for (int o : k) {
            finalRes[u] = o;

            u++;
        }

        return finalRes;
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
                if ((i != j) && (Math.abs(A[i] - A[j]) == B)) {
                    return 1;
                }
            }
        }
        return 0;

    }

    /*Given an array A and a integer B. A pair(i,j) in the array is a good pair if i!=j and (A[i]+A[j]==B). Check if any good pair exist or not.
      Problem Constraints 1 <= A.size() <= 104
                          1 <= A[i] <= 109
                          1 <= B <= 109
      Input Format: First argument is an integer array A.
      Second argument is an integer B.
      Output Format:  Return 1 if good pair exist otherwise return 0.
      Example Input
      Input 1: A = [1,2,3,4] B = 7
      Input 2: A = [1,2,4] B = 4
      Input 3: A = [1,2,2] B = 4
      Example Output Output 1: 1
      Output 2: 0
      Output 3: 1
      Example Explanation
      Explanation 1: (i,j) = (3,4)
      Explanation 2: No pair has sum equal to 4.
      Explanation 3: (i,j) = (2,3)*/
    public static int test(int[] A, int B) {
        int l, r;
        int n = A.length;

        Arrays.sort(A);
        l = 0;
        r = n - 1;
        while (l < r) {
            if (A[l] + A[r] == B)
                return 1;
            else if (A[l] + A[r] < B)
                l++;
            else
                r--;
        }
        return 0;
    }
}
