

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n + 1];

        dp[0] = 1;
        if (n == 2) dp[n] = 3;
        if (n >= 4) {
            dp[2] = 3;
            for (int i = 2; i <= n; i += 2) {
                dp[i] = dp[i - 2] * dp[2];
                for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] += dp[j] * 2;
                }
            }
        }
        if (n % 2 != 0) System.out.println(0);
        else System.out.println(dp[n]);
    }
}
