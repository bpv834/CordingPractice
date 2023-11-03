package DfsBfs;

import java.util.Scanner;

public class Memoization {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt(), r = sc.nextInt();
    static int sum = 0;

    public static void main(String[] args) {
        Dfs(0,n,r);
        System.out.println(sum);
    }

    static void Dfs(int L, int n, int r) {
        if (n == r || r == 1) {
            if (n == r) {
                sum++;
            } else if (r == 1) {
                sum += (n * r);
            }
        } else {
            Dfs(L + 1, n - 1, r - 1);
            Dfs(L + 1, n - 1, r);
        }
    }
}
