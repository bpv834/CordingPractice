package DfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class tomatoBfs {

    static Scanner sc = new Scanner(System.in);
    static Queue<Point> Q = new LinkedList<>();
    static int row[] = new int[]{-1, 1, 0, 0};
    static int column[] = new int[]{0, 0, -1, 1};

    static int m = sc.nextInt(), n = sc.nextInt();
    static int tomato[][] = new int[n][m];
    static int ch[][] = new int[n][m];


    static public void main(String[] args) {
        boolean clear = true;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tomato[i][j] = sc.nextInt();
                if (tomato[i][j] == 1) {
                    ch[i][j] = 1;
                    Q.offer(new Point(i, j));
                } else if (tomato[i][j] == -1) {
                    ch[i][j] = -1;
                }
            }
        }
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + row[i];
                int ny = tmp.y + column[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && tomato[nx][ny] != -1) {
                    if (tomato[nx][ny] == 0) {
                        System.out.println(nx + " " + ny);
                        tomato[nx][ny] = 1;
                        ch[nx][ny] = ch[tmp.x][tmp.y] + 1;
                        Q.add(new Point(nx, ny));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ch[i][j] == 0)
                    clear = false;
                answer = Math.max(answer, ch[i][j]);
            }
        }
        if (clear)
            System.out.println(answer - 1);
        else {
            System.out.println(-1);
        }

    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

