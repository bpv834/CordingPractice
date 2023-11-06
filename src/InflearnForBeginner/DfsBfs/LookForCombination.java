package InflearnForBeginner.DfsBfs;

import java.util.Scanner;

public class LookForCombination {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt(), m = sc.nextInt();
    static int arr[] = new int[m];
    static void Dfs(int L, int s) {
        if (L == m) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                arr[L] = i;
                Dfs(L + 1, i + 1);
            }
        }
    }
    public static void main(String[] args) {
        Dfs(0, 1);
    }
}
