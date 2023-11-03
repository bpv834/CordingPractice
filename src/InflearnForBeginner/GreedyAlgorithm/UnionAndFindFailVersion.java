package InflearnForBeginner.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UnionAndFindFailVersion {
    static String answer = "No";
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt(), m = sc.nextInt();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static PriorityQueue<Integer> pQ = new PriorityQueue<>();
    static int p1, p2;

    public static void main(String[] args) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            System.out.println("친구쌍 입력");
            graph.get(sc.nextInt()).add(sc.nextInt());
        }
        System.out.println("p1입력");
        p1 = sc.nextInt();
        System.out.println("p2입력");
        p2 = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            Search(i);
        }

        System.out.println(answer);
    }

    static void Search(int vtx) {
        int me = vtx;
        System.out.println("me= "+me);
        pQ.add(me);
        while (!pQ.isEmpty()) {
            int tmp = pQ.poll();
            for (int friend : graph.get(tmp)
            ) {
                System.out.println("tmp= "+tmp+" friend= "+friend);
                if (me == p1 && friend==p2) {
                    answer = "YES";
                    System.out.println("tmp= "+tmp+" friend= "+friend+"answer= "+answer);
                    break;
                }
                pQ.add(friend);
            }
        }
    }
}
