package GreedyAlgorithm;

import java.util.*;

public class DijkstraAlgorithm {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static PriorityQueue<Edge> pQ = new PriorityQueue<>();
    static int n = sc.nextInt(), m = sc.nextInt();
    static int dist[] = new int[n + 1];

    public static void main(String[] args) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(sc.nextInt()).add(new Edge(sc.nextInt(), sc.nextInt()));
        }
        Search(1);
        System.out.println(Arrays.toString(dist));
    }

    static void Search(int v) {
        //1부터 탐색 시작
        pQ.add(new Edge(v, 0));
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int nowVtx = tmp.vtx; //1
            int nowCost = tmp.cost; //0
            if (nowCost > dist[nowVtx]) continue;
            for (Edge edge : graph.get(nowVtx)
            ) {
                if (dist[edge.vtx] > nowCost + edge.cost) {
                    dist[edge.vtx] = nowCost+ edge.cost;
                    pQ.add(new Edge(edge.vtx, nowCost+ edge.cost));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int vtx;
        int cost;

        public Edge(int vtx, int cost) {
            this.vtx = vtx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

}
