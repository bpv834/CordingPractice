package InflearnForBeginner.Array;

import java.util.Scanner;

public class PrimeNumber {
    private static int pr(int n) {
        int result=0;
        for (int i = 2; i <= n; i++) {
            int cnt=0;
            for (int j = 1; j <= i - 1; j++) {
                if(i%j==0)
                    cnt++;

            }
            if(cnt==1)
                result++;


        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pr(sc.nextInt());
        System.out.println(pr(sc.nextInt()));
    }
}
