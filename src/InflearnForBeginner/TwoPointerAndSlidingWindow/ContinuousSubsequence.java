package InflearnForBeginner.TwoPointerAndSlidingWindow;

import java.util.Scanner;

public class ContinuousSubsequence {
    static Scanner sc = new Scanner(System.in);

    private static void sc(int n,int m) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int cnt=0;
        int value=0;
        int p1=0,p2=0;
        while (p2 < n) {


            if (value < m) {
                value += arr[p2++];

            }


            if(value==m ) {
                    cnt++;
                    value=value - arr[p1++];
            }

            if (value > m) {
                value = value - arr[p1++];
            }

        }
        System.out.println(cnt);
        }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        sc(n, m);


    }
}