package BaekJoonPractice.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        dp[3] = 0;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * dp[2];
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
