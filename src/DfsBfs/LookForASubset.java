package DfsBfs;

import java.util.Scanner;

public class LookForASubset {
    static Scanner sc = new Scanner(System.in);
    static int num = sc.nextInt();
    static int check[] = new int[num+1];
    private static void dfs(int n) {
        if(n<=num) {
            check[n] = 1;
            dfs(n+1);
            check[n]=0;
            dfs(n+1);
        }
        else {
            String answer="";
            for (int i = 1; i < num + 1; i++) {
                if (check[i] == 1) {
                    answer+=i+" ";
                }
            }
            System.out.println(answer);
        }
    }

    public static void main(String[] args) {
        dfs(1);

    }
}
