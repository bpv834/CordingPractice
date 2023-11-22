package BaekJoonPractice.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int k = Integer.parseInt(tk.nextToken());
        int coins[] = new int[n];

        int dp[][] = new int[n][k + 1];
        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(br.readLine());
        Arrays.sort(coins);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][0] = 1;
            }
        }
        if (coins[0] == 1) {
            for (int i = 1; i <= k; i++) {
                dp[0][i] = 1;
            }
        } else {
            for (int i = 1; i <= k; i++) {
                if (i % coins[0] == 0) {
                    dp[0][i] = 1;

                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (coins[i] > j) {
                    dp[i][j]=dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }

        System.out.println(dp[n-1][k]);
    }
}
