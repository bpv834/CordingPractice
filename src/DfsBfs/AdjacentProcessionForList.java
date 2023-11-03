package DfsBfs;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacentProcessionForList {
    static Scanner sc = new Scanner(System.in);
    static int answer=0;
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    static int ch[]=new int[n+1];
    static ArrayList<ArrayList<Integer>> graph;
    private static int dfl(int v) {
        if (v == n) {
            answer++;
        }
        else {
            for (int nx:graph.get(v)
                 ) {
                if(ch[nx]==0) {
                    ch[nx] = 1;
                    dfl(nx);
                    ch[nx] = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        graph= new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }


        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1]=1;
        System.out.println(dfl(1));
    }
}
