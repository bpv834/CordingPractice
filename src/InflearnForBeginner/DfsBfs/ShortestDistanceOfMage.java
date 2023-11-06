package InflearnForBeginner.DfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestDistanceOfMage {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int row[] = new int[]{-1, 1, 0, 0};
    static int column[] = new int[]{0, 0, -1, 1};
    static int dist[][] = new int[8][8];
    static int board[][] = new int[8][8];
    static Queue<Point> Q = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    static void Bfs(int x, int y) {
        board[x][y]=1;
        Q.add(new Point(x, y));
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + row[i];
                int ny = tmp.y + column[i];
                if (nx > 0 && nx < 8 && ny > 0 && ny < 8 && board[nx][ny] == 0) {
                    board[nx][ny]=1;
                    Q.add(new Point(nx, ny));
                    dist[nx][ny]=dist[tmp.x][tmp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        Bfs(1, 1);
        if (dist[7][7] == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(dist[7][7]);
        }
    }
}
