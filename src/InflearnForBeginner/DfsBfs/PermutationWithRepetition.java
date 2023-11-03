package InflearnForBeginner.DfsBfs;

import java.util.Scanner;

public class PermutationWithRepetition {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt(), m = sc.nextInt();
    static int pm[] = new int[m];

    public static void main(String[] args) {
        Dfs(0);
    }

    static void Dfs(int L) {
        if (L == m) {
            for (int n:pm
                 ) {
                System.out.print(n+" ");
            }
            System.out.println();
        }
        else {
            for (int i=1;i<=n;i++){
                pm[L]=i;
                Dfs(L+1);
            }
        }
    }

}
