package BaekJoonPractice.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3109 {
    static BufferedReader br;
    static StringTokenizer tk;
    static int[] dCol = new int[]{-1, 0, 1};
    static int cnt = 0;
    static int R;
    static int C;
    static char[][] gasMaps;

    static boolean Dfs(int col, int L) {
        if (L == C - 1) {
            return true;
        } else {
            if (gasMaps[col][L] == '.') {
                gasMaps[col][L] = 'X';
                for (int i = 0; i < 3; i++) {
                    int nCol = col + dCol[i];
                    int nRow = L + 1;
                    if (nCol >= 0 && nCol < R && nRow < C && gasMaps[nCol][nRow] == '.') {
                        if (Dfs(nCol, nRow)) return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        tk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(tk.nextToken());
        C = Integer.parseInt(tk.nextToken());

        gasMaps = new char[R][C];
        for (int i = 0; i < R; i++) {
            String col = br.readLine();
            for (int j = 0; j < C; j++) {
                gasMaps[i][j] = col.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            if (Dfs(i, 0)) cnt++;
        }
        System.out.println(cnt);
    }
}