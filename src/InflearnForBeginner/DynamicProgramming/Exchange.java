package InflearnForBeginner.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Exchange {
    // 최소 경우의수가 구해지지 않아 dp[m]값이 인피니티일때의 경우를 고려하지 않음
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coin[] = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int dy[] = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0]=0;

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j]=Math.min(dy[j],dy[j-coin[i]]+1);
            }
        }
        System.out.println(dy[m]);
    }
}
