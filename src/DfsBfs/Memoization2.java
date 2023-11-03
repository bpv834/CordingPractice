package DfsBfs;
import java.util.Scanner;

public class Memoization2 {
    static Scanner sc = new Scanner(System.in);
    static int dy[][] = new int[35][35];
    static int n=sc.nextInt(), r = sc.nextInt();
    public static void main(String[] args) {
        System.out.println(Dfs(n, r));
    }

    static int Dfs(int n, int r) {
        if(dy[n][r]>0)
            return dy[n][r];
        if(n==r||r==0)
            return 1;
        else {
            return dy[n][r]=Dfs(n - 1, r - 1) + Dfs(n - 1, r);
        }
    }


}
