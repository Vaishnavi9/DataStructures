package com.StringImpQuestions;

public class Main {
    public static void main(String[] args) {

    }
//asked in google Modulo mathematics
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
}
