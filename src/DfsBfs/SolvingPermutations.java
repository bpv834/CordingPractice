package DfsBfs;

import java.util.Scanner;

public class SolvingPermutations {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt(), m = sc.nextInt();
    static int arr[] = new int[n];
    static int pm[] = new int[m];
    static int ch[] = new int[n];


    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Dfs(0);
    }

    static void Dfs(int L) {
        if (L == m) {
            for (int x : pm
            ) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    pm[L] = arr[i];
                    ch[i] = 1;
                    Dfs(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
