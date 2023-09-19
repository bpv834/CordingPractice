package memoBfs;

import java.util.Scanner;
import java.util.Stack;

public class AdjacentProcession {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();//볼텍스 수
    static int m = sc.nextInt();//간선 수
    static int graph[][] = new int[n+1][n+1];
    static int ch[]=new int[n+1];
    static int answer=0;

    private static int dfs(int v) {

        System.out.println(answer+" "+v);
        if (v == n) {
            answer++;
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1&& ch[i]==0) {
                    ch[i]=1;
                    dfs(i);
                    ch[i]=0;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {


        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b]=1;
        }
        ch[1]=1;
        System.out.println(dfs(1));

    }
}
