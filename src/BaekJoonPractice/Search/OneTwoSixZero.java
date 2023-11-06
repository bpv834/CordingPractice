package BaekJoonPractice.Search;

import java.util.*;

public class OneTwoSixZero {
    static boolean ch[];
    static String answerD = "";
    static String answerB="";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        ch = new boolean[n + 1];
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i < n; i++) Collections.sort(graph.get(i));
        Dfs(graph, v);
        System.out.println(answerD.trim());
        Arrays.fill(ch, false);
        Bfs(graph,v,Q);
        System.out.println(answerB.trim());


    }

    static void Dfs(ArrayList<ArrayList<Integer>> graph, int v) {
        answerD += v + " ";
        ch[v] = true;
        for (int nv : graph.get(v)
        ) {
            if (!ch[nv]) Dfs(graph, nv);
        }
    }

    static void Bfs(ArrayList<ArrayList<Integer>> graph, int v, Queue<Integer> Q) {
        Q.add(v);
        ch[v] = true;
        while (!Q.isEmpty()) {
            int cv = Q.poll();
            answerB += cv + " ";
            for (int nv : graph.get(cv)
            ) {
                if (!ch[nv]) {
                    Q.add(nv);
                    ch[nv]=true;
                }
            }
        }
    }

}
