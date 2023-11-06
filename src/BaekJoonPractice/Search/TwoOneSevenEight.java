package BaekJoonPractice.Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TwoOneSevenEight {
    static int dx[] = new int[]{-1, 1, 0, 0};
    static int dy[] = new int[]{0, 0, -1, 1};
    static Queue<Edge> Q = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    static int [][] board=new int[n+1][m+1];
    static int [][] dist=new int[n+1][m+1];

    public static void main(String[] args) {
        for (int i = 1; i <= n; i++) {
            int col = sc.nextInt();
            for (int j = 1; j <= m; j++) {
                String num=Integer.toString(col);
                int jRow=num.charAt(j-1)-48;
                System.out.println(jRow);
                board[i][j] = jRow;
            }
        }
        dist[1][1]=1;
        Q.add(new Edge(1, 1));
        while (!Q.isEmpty()) {
            Edge tmp=Q.poll();
            System.out.println(tmp.x);
            int cx=tmp.x;
            int cy=tmp.y;
            System.out.println("cx= "+cx+" cy= "+cy);
            for (int i = 0; i < 4; i++) {
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m && dist[nx][ny]==0 && board[nx][ny]==1) {
                    Q.add(new Edge(nx, ny));
                    dist[nx][ny]=dist[cx][cy]+1;
                }
            }
        }
        System.out.println(dist[n][m]);
    }
    static class Edge{
        int x;
        int y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}