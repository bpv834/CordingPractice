package DfsBfs;

import java.util.Arrays;
import java.util.Scanner;

public class ExchangeCoin {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int arr[] = new int[n];
    static int exchanges;
    static int answer=Integer.MAX_VALUE;

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        exchanges = sc.nextInt();
        Dfs(0,0,arr);
        System.out.println(answer);
    }

    static void Dfs(int L, int sum, int arr[]) {
        if (sum > exchanges) {
            return;
        }
        if (L >= answer) {
            return;
        }
        if (sum ==exchanges) {
            answer = Math.min(L, answer);
        }
        else {
            for (int i = n-1; i >= 0; i--) {
                Dfs(L+1,sum+arr[i],arr);
            }
        }
    }
}
