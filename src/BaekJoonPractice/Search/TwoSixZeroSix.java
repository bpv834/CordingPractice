package BaekJoonPractice.Search;

import java.util.ArrayList;
import java.util.Scanner;

public class TwoSixZeroSix {
    static Scanner sc = new Scanner(System.in);
    static int answer=0;
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    static int ch[] = new int[n + 1];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        Dfs(1);
        System.out.println(answer);

    }
    static void Dfs(int v){
        answer++;
        ch[v]=1;
        for (int nv:graph.get(v)
             ) {
            if (ch[nv] == 0) {
                System.out.println(nv);
                Dfs(nv);
            }
        }
    }
}
