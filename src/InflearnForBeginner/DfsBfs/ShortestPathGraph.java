package InflearnForBeginner.DfsBfs;

import java.util.*;

public class ShortestPathGraph {
    static Scanner sc = new Scanner(System.in);

    static int n = sc.nextInt();
    static int m = sc.nextInt();

    static int ch[] = new int[n + 1];
    static Queue<Integer> q = new LinkedList();
    static int dis[] = new int[n + 1];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static void spg(int v) {
        System.out.println("v="+v);
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.println("x="+x);
            System.out.println(q);
            for (int nv:graph.get(x)
            ) {
                if (ch[nv] == 0) {
                    ch[nv]=1;
                    q.offer(nv);
                    dis[nv] = dis[x] + 1;

                }
            }
        }

    }

    public static void main(String[] args) {


        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
        }
        ch[1]=1;
        dis[1]=0;
        q.offer(1);
        spg(1);
        System.out.println(Arrays.toString(dis));
    }
}
