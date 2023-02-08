package TwoPointerAndSlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class LargestSales {
    static Scanner sc = new Scanner(System.in);

    private static void ls(int n, int m) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer=0;
        for (int i = 0; i < m; i++) {
            answer += arr[i];
        }
        int p1=0,p2=m;
        int value=answer;

        while (p1 < (n - m)) {
            answer = answer+  arr[p2++]- arr[p1++];
            if (value < answer) {
                value=answer;
            }
        }
        System.out.println(value);


    }


    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        ls(n, m);

    }
}