package DfsBfs;

import java.util.Scanner;

public class PickUpAtTruck {
    static int answer=0;
    static Scanner sc = new Scanner(System.in);
    static  int c = sc.nextInt();
    static int n = sc.nextInt();
    static int arr[] = new int[n];

    static void Dfs(int L, int sum) {
        if(sum>c)
            return;
        if (L == n) {
            if (sum <= c && sum > answer) {
                answer=sum;
            }
        }
        else {
            Dfs(L + 1, sum + arr[L]);
            Dfs(L + 1, sum);
        }

    }

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Dfs(0, 0);
        System.out.println(answer);
    }
}
