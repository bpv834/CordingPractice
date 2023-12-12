package BaekJoonPractice.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5014 {
    static BufferedReader br;
    static int f, s, g, u, d;
    static int ch[] = new int[100001];
    static boolean flag = false;
    static Queue<Edge> q = new LinkedList<>();

    static void Bfs(int vtx, int L) {
        q.add(new Edge(vtx, L));
        while (!q.isEmpty()) {
            Edge nowEdge = q.poll();
            int nowVtx = nowEdge.vtx;
            int nowL = nowEdge.L;
            if (nowVtx < 1 || nowVtx > f) continue;
            if (ch[nowVtx] == 1) continue;
            ch[nowVtx] = 1;
            if (nowVtx == g) {
                System.out.println(nowL);
                flag = true;
                break;
            } else {
                int nu = nowVtx + u;
                int nd = nowVtx - d;
                if (nu >= 0 && nu <= 1000000) q.add(new Edge(nu, nowL + 1));
                if (nd >= 0 && nd <= 1000000) q.add(new Edge(nd, nowL + 1));
            }
        }
        if (!flag) System.out.println("use the stairs");
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer tk = new StringTokenizer(str);
        f = Integer.parseInt(tk.nextToken());
        s = Integer.parseInt(tk.nextToken());
        g = Integer.parseInt(tk.nextToken());
        u = Integer.parseInt(tk.nextToken());
        d = Integer.parseInt(tk.nextToken());

        Bfs(s, 0);
    }

    static class Edge {
        int vtx;
        int L;

        public Edge(int vtx, int l) {
            this.vtx = vtx;
            L = l;
        }
    }
}
