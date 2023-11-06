package InflearnForBeginner.Array;

import java.util.Scanner;

public class DicisionMento {
    static Scanner sc = new Scanner(System.in);

    private static void dm(int n, int m) {
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int result=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt=0;
                int pi=0,pj=0;
                for (int k = 0; k < m; k++) {
                    for (int s = 0; s < n; s++) {
                        if(arr[k][s]==i) {
                            pi = s;
                        }
                        if(arr[k][s]==j) {
                            pj = s;
                        }
                    }
                    if(pi<pj)
                        cnt++;
                }
                if(cnt==m)
                    result++;

            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        dm(sc.nextInt(), sc.nextInt());
    }
}
