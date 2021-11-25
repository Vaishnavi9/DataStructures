package com.StringImpQuestions;

public class Main {
    public static void main(String[] args) {

    }
//asked in google Modulo mathematics
/*Problem Description
  You are given a huge number in the form of a string A where each character denotes a digit of the number.
  You are also given a number B. You have to find out the value of A % B and return it.
  Problem Constraints 1 <= A.size() <= 105, 0 <= Ai <= 9,1 <= B <= 109
  Input Format
  The first argument is the string A.
  The second argument is the integer B.
  Output Format: Return a single integer denoting the value of A % B.
  Example Input
  Input 1: A = "143" B = 2
  Input 2: A = "43535321" B = 47
  Example Output--- Output 1: 1 Output 2: 20
  Example Explanation
  Explanation 1: 143 is an odd number so 143 % 2 = 1.
  Explanation 2: 43535321 % 47 = 20*/
    public static int findMod(String A, int B) {
        long ans = 0;
        long p10 = 1;
        for (int i = A.length()-1; i >= 0; i--){
            int x = A.charAt(i) - '0';
            ans += x*(p10);
            p10 = (p10*10)%B < 0 ? ((p10*10)%B)+B : (p10*10)%B;
            ans = ans % B;

        }

        return ans%B < 0 ? (int)((ans%B)+B) : (int)(ans%B);
    }

    /*Problem Description
      Given a column title as appears in an Excel sheet, return its corresponding column number.
      Problem Constraints 1 <= length of the column title <= 5
      Input Format -> Input a string which represents the column title in excel sheet.
      Output Format -> Return a single integer which represents the corresponding column number.
      Example Input
      Input 1: AB
      Input 2: ABCD
      Example Output
      Output 1: 28
      Output 2: 19010
      Example Explanation
      Explanation 1: A -> 1 B -> 2 C -> 3...Z -> 26 AA -> 27 AB -> 28
      */

    public int titleToNumber(String A) {

        int output = 0;
        for (int i = 0; i < A.length(); i++)
        {
            output *= 26;
            output += A.charAt(i) - 'A' + 1;
        }
        return output;
    }
}
