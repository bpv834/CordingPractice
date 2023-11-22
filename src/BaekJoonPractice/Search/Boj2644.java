package BaekJoonPractice.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Boj2644 {
    static BufferedReader br;
    static int n, m;
    static int p1, p2;
    static StringTokenizer tk;
    static int ch[];
    static boolean flag = false;

    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String relation = br.readLine();
        tk = new StringTokenizer(relation);
        p1 = Integer.parseInt(tk.nextToken());
        p2 = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(br.readLine());
        ch = new int[n + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            tk = new StringTokenizer(str);
            int parent = Integer.parseInt(tk.nextToken());
            int child = Integer.parseInt(tk.nextToken());

            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }
        Dfs(p1, 0);
        if(!flag) System.out.println(-1);
    }

    static void Dfs(int p, int L) {
        ch[p] = 1;
        if (p == p2) {
            flag = true;
            System.out.println(L);
        } else {
            for (int np : graph.get(p)
            ) {
                if (ch[np] == 0) {
                    Dfs(np, L + 1);
                }
            }
        }
    }
}
