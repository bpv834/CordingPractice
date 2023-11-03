package InflearnForBeginner.DfsBfs;

import java.util.Scanner;

public class GuessingPermutation {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt(), f = sc.nextInt();
    static int ub[] = new int[n];
    static int db[] = new int[n];
    static int ch[] = new int[n + 1];
    static int dy[][] = new int[35][35];
    static int sum = 0;
    static boolean flag = false;

    public static void main(String[] args) {
        Dfs(0);
    }

    static void Dfs(int L) {
        if (flag)
            return;

        if (L == n) {
            for (int i = 0; i < L; i++)
                sum += (ub[i] * db[i]);

            if (sum == f) {
                for (int x : db) {
                    System.out.print(x + " ");
                }
                flag = true;
            }
            sum = 0;
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ub[L] = combi(n - 1, L);
                    db[L] = i;
                    ch[i] = 1;
                    Dfs(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    static int combi(int n, int r) {
        if (dy[n][r] > 0)
            return dy[n][r];
        if (n == r || r == 0)
            return 1;
        else {
            return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }
}
