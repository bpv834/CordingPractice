package BaekJoonPractice.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1890 {
    static BufferedReader br;
    static int n;

    static long Dfs(int ci, int cj) {
        if (ci == n && cj == n) return 1;

        if (dp[ci][cj] == -1) {
            dp[ci][cj] = 0;


            if (cj + maps[ci][cj] <= n) dp[ci][cj] += Dfs(ci, cj + maps[ci][cj]);
            if (ci + maps[ci][cj] <= n) dp[ci][cj] += Dfs(ci + maps[ci][cj], cj);
        }
        return dp[ci][cj];
    }

    static int maps[][];
    static long dp[][];


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maps = new int[n + 1][n + 1];
        dp = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String col = br.readLine();
            StringTokenizer tk = new StringTokenizer(col);
            for (int j = 1; j <= n; j++) {
                maps[i][j] = Integer.parseInt(tk.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(Dfs(1, 1));
    }
}
