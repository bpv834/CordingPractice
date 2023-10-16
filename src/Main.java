import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
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
            graph.get(sc.nextInt()).add(sc.nextInt());
        }
        p1 = sc.nextInt();
        p2 = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            Search(i);
        }

        System.out.println(answer);
    }

    static void Search(int vtx) {
        int me = vtx;
        pQ.add(me);
        while (!pQ.isEmpty()) {
            int tmp = pQ.poll();
            for (int friend : graph.get(tmp)
            ) {
                if (me == p1 && friend==p2) {
                    answer = "YES";
                    break;
                }
                pQ.add(friend);
            }
        }
    }
}
