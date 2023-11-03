package InflearnForBeginner.DfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SolvingIsland {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int board[][] = new int[n][n];
    static int ch[][] = new int[n][n];
    static int cnt = 1;

    static int xp[] = new int[]{-1, -1, 0, 1, 1, 1, 0, -1,};
    static int yp[] = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
    static Queue<Point> Q = new LinkedList<>();


    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && ch[i][j] == 0) {
                    ch[i][j]=cnt;
                    System.out.println(i+" "+j);
                    Q.offer(new Point(i, j));
                    while (!Q.isEmpty()) {
                        Point tmp=Q.poll();
                        ch[tmp.x][tmp.y]=ch[i][j];
                        for (int k = 0; k < 8; k++) {
                            int nx = tmp.x + xp[k];
                            int ny = tmp.y + yp[k];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny]==0 && board[nx][ny]==1) {
                                Q.add(new Point(nx, ny));
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ch[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(cnt-1);
    }

}
