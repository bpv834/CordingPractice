package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimAlgorithm {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static PriorityQueue<Edge> pQ = new PriorityQueue<>();
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    static int ch[] = new int[n + 1];
    static int answer = 0;

    public static void main(String[] args) {
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        Search(1);
        System.out.println(answer);
    }


    static void Search(int vtx) {
        pQ.add(new Edge(vtx, 0));
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int now = tmp.vtx;
            int nowCost = tmp.cost;
            System.out.println("now= " + now + " nowCost= " + nowCost);
            if (ch[now] == 0) {
                System.out.println(now+"를 체크");
                ch[now] = 1;
                answer += nowCost;
                System.out.println("answer= " + answer);
                for (Edge e : graph.get(now)
                ) {
                    Edge edge = new Edge(e.vtx, e.cost);
                    System.out.println("now= " + now + " now에 연결된 vtx= " + edge.vtx + " " + " now에 연결된 cost= " + edge.cost);
                    ch[now] = 1;
                    if (ch[edge.vtx] == 0) pQ.add(edge);

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
