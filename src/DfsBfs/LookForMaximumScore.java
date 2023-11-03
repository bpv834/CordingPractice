package DfsBfs;

import java.util.Arrays;
import java.util.Scanner;


public class LookForMaximumScore {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt(), m = sc.nextInt();
    static int L = 0, max = 0;
    static int arr[][] = new int[n+1][2];

    public static void main(String[] args) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        DFS(0, 0,0, arr);
        System.out.println(max);
    }

    static void DFS(int L, int sumT, int sumS, int arr[][]) {
        if(sumT>m)
            return;
        if (L == n) {
            if (sumS > max) {
                max = sumS;
            }
        }
        else{
            DFS(L+1 , sumT,sumS,arr);
            DFS(L+1 , sumT+arr[L+1][1], sumS+arr[L+1][0], arr);
        }

    }
}
