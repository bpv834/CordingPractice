package InflearnForBeginner.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KruskalAlgorithm {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt(), m = sc.nextInt();
    static int parent[] = new int[n + 1];
    static ArrayList<Edge> graph = new ArrayList<>();
    static int answer = 0;

    static int Find(int me) {
        if (parent[me] == me) return me;
        else return Find(parent[me]);
    }

    static Boolean Union(int v1, int v2) {
        int fv1 = Find(v1);
        int fv2 = Find(v2);
        if (fv1 != fv2) {
            parent[fv2] = fv1;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            graph.add(new Edge(v1, v2, cost));
        }
        Collections.sort(graph);
        for (Edge edge : graph) {
            System.out.println(edge.v1 + " " + edge.v2 + " " + edge.cost);
            if (Union(edge.v1, edge.v2)) {
                answer += edge.cost;
                System.out.println(answer);
            } else {
                System.out.println("어?");
            }
        }


    }

    public static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }


}
