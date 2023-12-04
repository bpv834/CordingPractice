package BaekJoonPractice.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1520 {
    static BufferedReader br;
    static int n, m;
    static int maps[][];
    static int dp[][];
    static int dCol[] = new int[]{-1, 1, 0, 0};
    static int dRow[] = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer tk = new StringTokenizer(str);
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        maps = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];


        for (int i = 1; i <= n; i++) {
            String col = br.readLine();
            tk = new StringTokenizer(col);
            for (int j = 1; j <= m; j++) {
                maps[i][j] = Integer.parseInt(tk.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(Dfs(1, 1));

    }

    static int Dfs(int ci, int cj) {
        if (ci == n && cj == m) return 1;

        if (dp[ci][cj] == -1) {
            dp[ci][cj]=0;
            for (int i = 0; i < 4; i++) {
                int ni = ci + dCol[i];
                int nj = cj + dRow[i];

                if (ni >= 1 && ni <= n && nj >= 1 && nj <= m && maps[ci][cj] > maps[ni][nj]) dp[ci][cj] += Dfs(ni, nj);
            }
        }
        return dp[ci][cj];
    }
}
