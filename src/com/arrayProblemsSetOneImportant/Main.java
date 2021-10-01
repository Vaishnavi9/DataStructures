package com.arrayProblemsSetOneImportant;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 1};
        int[] b = {1, 1, 2};
        ArrayList<Integer> aa = new ArrayList<Integer>() {{
            add(2);
            add(1);
            add(4);
            add(10);
            add(10);
        }};
        ArrayList<Integer> bb = new ArrayList<Integer>() {{
            add(3);
            add(6);
            add(2);
            add(10);
            add(10);
            add(1);
        }};
        //ArrayList<Integer> result = checkCommonElementsInTwoArrays(aa,bb);

        //System.out.println(checkFirstRepeatedOccurrenceType2(ab, ab.length));
/*        System.out.println(checkFirstRepeatedOccurrenceType1(ab, ab.length));
        System.out.println(checkIfSubArrayContainsSumZero(a, a.length));*/

        ArrayList<Integer> t = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        //System.out.println(addOneToNumber(t));

        int[] inputPrefixSum = {1, 2, 3, 4, 5, 6, 7};
        int[][] query = {{0, 3}, {2, 5}, {3, 6}};
//prefixMethod(inputPrefixSum, query);
        //Beggars plate sum
        ArrayList<ArrayList<Integer>> beggarInput = new ArrayList<ArrayList<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(1);
                add(2);
                add(10);
            }});
            add(new ArrayList<Integer>() {{
                add(2);
                add(3);
                add(20);
            }});
            add(new ArrayList<Integer>() {{
                add(2);
                add(5);
                add(25);
            }});
        }};
        //no. of beggars
        int k = 5;
        beggarsPlate(k, beggarInput);


    }

//    Input:
//    N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
//
//    Return: [10, 55, 45, 25, 25]
//
//    Explanation:
//            => First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
//
//            => Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
//
//            => Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]

    public static ArrayList<Integer> beggarsPlate(int k, ArrayList<ArrayList<Integer>> input) {
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(new Integer[k]));
        Collections.fill(result, 0);

        for (int i = 0; i < input.size(); i++) {
            int left = input.get(i).get(0) - 1;
            int right = input.get(i).get(1) - 1;
            int donation = input.get(i).get(2);
            result.set(left, result.get(left) + donation);
            if (right + 1 < k) {
                result.set(right + 1, result.get(right + 1) - donation);
            }


        }
        for (int i = 1; i < k; i++) {
            result.set(i, result.get(i) + result.get(i - 1));
        }
        for (int i : result) System.out.print(i + " ");

        return result;
    }

    //query the sum of data in given range from array
    public static void prefixMethod(int[] input, int[][] query) {
        int[] prefix = new int[input.length];
        int[] result = new int[query.length];
        int sum = 0;

        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            prefix[i] = sum;
        }

        for (int i = 0; i < query.length; i++) {
            int left = query[i][0];
            int right = query[i][1];
            result[i] = prefix[right] - prefix[left] + input[left];
        }

        for (int i : result) System.out.print(i + " ");
    }


    //sub array with sum zero
    public static int checkIfSubArrayContainsSumZero(int[] A, int n) {
        int result = 0;
        long sum = 0;
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            sum += A[i];
            if (sum == 0 || A[i] == 0 || set.contains(sum)) {
                result = 1;
                break;
            }
            set.add(sum);
        }

        System.out.println(set);
        return result;
    }


    //check the first occurrence of a number in array {1,5,3,3,5,0}  result = 5
    public static int checkFirstRepeatedOccurrenceType1(int[] a, int n) {
        int index = -1;
        Set<Integer> test = new LinkedHashSet<>();

        for (int i = n - 1; i >= 0; i--) {
            if (test.contains(a[i])) {
                index = i;
                break;
            } else {
                test.add(a[i]);
            }
        }
        System.out.println(test);
        return a[index];
    }

    //check the first occurrence of a number in array {1,5,3,1,3,5,0}  result = 1
    public static int checkFirstRepeatedOccurrenceType2(int[] a, int n) {
        int index = -1;
        Set<Integer> test = new LinkedHashSet<>();

        for (int i = 0; i < n - 1; i++) {
            if (test.contains(a[i])) {
                index = i;
                break;
            } else {
                test.add(a[i]);
            }
        }
        System.out.println(test);
        return a[index];
    }


    //check common elements in 2 arrays
    public static ArrayList<Integer> checkCommonElementsInTwoArrays(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> f = new HashMap<>();

        for (Integer i : a) {
            if (f.containsKey(i)) {
                f.put(i, f.get(i) + 1);
            } else {
                f.put(i, 1);
            }

        }


        for (int i = 0; i < b.size(); i++) {
            if (f.containsKey(b.get(i)) && f.get(b.get(i)) > 0) {
                result.add(b.get(i));
                f.put(b.get(i), f.get(b.get(i)) - 1);
            }
        }
        return result;
    }

    //consider elements of an array as 1 digit and add 1 to it
    public static ArrayList<Integer> addOneToNumber(ArrayList<Integer> input) {
        int carry = 0;
        if (input.size() > 0) {
            for (int i = 0; i < input.size(); i++) {
                if (input.get(0) == 0) {
                    input.remove(0);
                } else break;
            }
        }

        if (input.size() == 0) return new ArrayList<Integer>() {{
            add(1);
        }};

        int n = input.size() - 1;
        while (n >= 0) {
            if (input.get(n) == 9) {
                input.set(n, 0);
                n--;
                carry = 1;
            } else {
                input.set(n, input.get(n) + 1);
                return input;
            }
        }
        if (carry == 1 && input.get(0) == 0) {
            input.set(0, 1);
            input.add(0);
        }
        return input;
    }

    /*  Given an array of integers A, every element appears twice except for one. Find that single one.
        NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? (Use bit manipulation)
          i/p -> A = [1, 2, 2, 3, 1]  o/p ->  3 i/p -> [1, 2, 2] o/p -> 1

      */
    public static int singleNumber(final List<Integer> A) {

        int num = 0;
        for (int val : A) {
            num ^= val;
        }
        return num;

    }

    /*Write a function that takes an integer and returns the number of 1 bits it has.
     * i/p - > 11 o/p -> 3 because 11 is represented in binary as 1011 so number of bit 1 are 3
     * */
    public static int numSetBits(int A) {
        int total_ones = 0;
        while (A != 0) {
            A = A & (A - 1);
            total_ones++;
        }
        return total_ones;
    }

    /*Given two binary strings, return their sum (also a binary string).
    Example:

    a = "100"

    b = "11"
    Return a + b = "111".*/
    public static String addBinary(String A, String B) {

        String result = "";

        // Initialize digit sum
        int s = 0;

        // Traverse both strings starting
        // from last characters
        int nA, nB;
        char[] res;
        int i, j, k;
        nA = A.length();
        nB = B.length();
        res = new char[Math.max(nA, nB) + 1];
        k = Math.max(nA, nB);
        i = nA - 1;
        j = nB - 1;
        int sum = 0, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            sum = carry;
            if (i >= 0)
                sum += (A.charAt(i) - '0');
            if (j >= 0)
                sum += (B.charAt(j) - '0');
            res[k] = (char) ((sum % 2) + '0');
            carry = sum / 2;
            i--;
            j--;
            k--;
        }
        if (res[0] == '1')
            return new String(res);
        int len = Math.max(nA, nB);
        return new String(res, 1, len);
    }


    /*Input 1:
    A = [1, 2, 2, 5, 6]
    Output 1:
            4
    Explanation 1:
    Maximum length odd even subsequence is [1, 2, 5, 6]

    Input 2:
    A = [2, 2, 2, 2, 2, 2]
    Output 2:
            1
    Explanation 2:
    Maximum length odd even subsequence is [2]*/

    public static int oddEvenSubsequence(ArrayList<Integer> A) {
        for (int i = 0; i < A.size() - 1; i++) {
            if ((A.get(i) % 2 == 0 && A.get(i + 1) % 2 == 0) || (A.get(i) % 2 != 0 && A.get(i + 1) % 2 != 0)) {
                A.remove(i + 1);
                i = i - 1;
            }
        }

        return A.size();
    }


    /*  You are given an integer array A and an integer B. You have to print the same array after rotating it B times towards right.
        NOTE: You can use extra memory.
        Problem Constraints 1 <= |A| <= 106 1 <= A[i] <= 109 1 <= B <= 109
        Input Format
        First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
        Second line contains a single integer B
        Output Format
        Print an array of integers which is the Bth right rotation of input array A, on a separate line.
        Example Input
        Input 1: 4 1 2 3 4 k=2
        Input 2: 3 1 2 2  k=3
        Example Output Output 1: 3 4 1 2 Output 2:1 2 2
        Example Explanation
        Explanation 1: [1,2,3,4] => [4,1,2,3] => [3,4,1,2]
        Explanation 2: [1,2,2] => [2,1,2] => [2,2,1] => [1,2,2]*/
    public static void sol() {
        Scanner scanner = new Scanner(System.in);
        Integer size = scanner.nextInt();
        int[] array = new int[size];
        int count = 0;
        while (size > 0) {

            array[count] = scanner.nextInt();
            count++;
            size--;
        }
        Integer b = scanner.nextInt();

        int n = array.length;
        b = b % n;

        for (int i = 0; i < n; i++) {
            if (i < b) {
                System.out.print(array[n + i - b] + " ");
            } else {
                System.out.print(array[i - b] + " ");
            }
        }
    }


    /*Given an array of integers A, update every element with multiplication of previous and next elements with following exceptions.
        a) First element is replaced by multiplication of first and second.
        b) Last element is replaced by multiplication of last and second last.
        Input Format The only argument given is the integer array A.
        Output Format Return the updated array.
        Constraints 1 <= length of the array <= 100000 -10^4 <= A[i] <= 10^4
        For Example Input 1: A = [1, 2, 3, 4, 5] Output 1: [2, 3, 8, 15, 20]
                    Input 2: A = [5, 17, 100, 11] Output 2: [85, 500, 187, 1100]
    */
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {

        ArrayList<Integer> resultList = new ArrayList<>(A.size());
        if (A.size() > 1) {
            for (int i = 0; i < A.size(); i++) {
                if (i == 0) {
                    resultList.add(A.get(i) * A.get(i + 1));
                } else if (i == A.size() - 1) {
                    resultList.add(i, A.get(i) * A.get(i - 1));
                } else {
                    resultList.add(i, A.get(i + 1) * A.get(i - 1));
                }
            }
        } else if (A.size() == 0 || A.size() == 1) {
            return A;
        }

        return resultList;
    }


    /*"Primal Power" of an array is defined as the count of prime numbers present in it.
       Given an array of integers A of length N, you have to calculate its Primal Power.
       Problem Constraints 1 <= N <= 103 -106 <= A[i] <= 106
       Input Format - First and only argument is an integer array A.
       Output Format Return the Primal Power of array A.
       Example Input -> Input 1: A = [-6, 10, 12] o/p -> 0
                        Input 2: A = [-11, 7, 8, 9, 10, 11] o/p -> 2
       */

    public static int primalPower(ArrayList<Integer> input) {
        int primalPower = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) > 0 && isPrime(input.get(i))) {
                primalPower++;
            }
        }

        return primalPower;
    }

    static boolean isPrime(int n) {


        if (n <= 1)
            return false;


        else if (n == 2)
            return true;

        else if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }


    /*Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
      The digits are stored such that the most significant digit is at the head of the list.
      NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, following are some good questions to ask :
      Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
      A : For the purpose of this question, YES
      Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
      A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
      Problem Constraints 1 <= size of the array <= 1000000
      Input Format First argument is an array of digits.
      Output Format Return the array of digits after adding one.
      Example Input
      Input 1: [1, 2, 3] Output 1: [1, 2, 4]
      Explanation 1:
      Given vector is [1, 2, 3].
      The returned vector should be [1, 2, 4] as 123 + 1 = 124.*/

    public static ArrayList<Integer> plusOne(ArrayList<Integer> input) {
        int carry = 0;
        if (input.size() > 0) {
            for (int i = 0; i < input.size(); i++) {
                if (input.get(0) == 0) {
                    input.remove(0);
                } else {
                    break;
                }
            }
        }
        if (input.size() == 0) {
            return new ArrayList<Integer>() {{
                add(1);
            }};
        }
        int n = input.size() - 1;
        while (n >= 0) {
            if (input.get(n) == 9) {
                input.set(n, 0);
                n--;
                carry = 1;
            } else {
                input.set(n, input.get(n) + 1);
                return input;
            }
        }
        if (carry == 1 && input.get(0) == 0) {
            input.set(0, 1);
            input.add(0);
        }
        return input;
    }



}
