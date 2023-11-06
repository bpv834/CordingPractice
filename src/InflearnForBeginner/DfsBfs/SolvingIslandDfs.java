package InflearnForBeginner.DfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SolvingIslandDfs {
    //나는 체크 배열을 만들어서 풀었는데 해설은 애초에 인접한 칸은 dfs로 접근해 0으로 바꾸고 1일때만 카운트 해서 풀었다 와우...
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int board[][] = new int[n][n];
    static int ch[][] = new int[n][n];
    static int xp[] = new int[]{-1, -1, 0, 1, 1, 1, 0, -1,};
    static int yp[] = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
    static int cnt = 0;
    static Queue<Point> Q = new LinkedList<>();

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void Dfs(int x, int y) {
        System.out.println("Dfs "+x+" "+y);
        for (int i = 0; i < 8; i++) {
            int nx = x + xp[i];
            int ny = y + yp[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 1 && ch[nx][ny] == 0) {
                ch[nx][ny] = 1;
                Dfs(nx, ny);
            }
        }


    }

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && ch[i][j] == 0) {
                    System.out.println(i+" "+j);
                    ch[i][j] = 1;
                    cnt++;
                    Dfs(i, j);
                }
            }
        }
        System.out.println("섬의 개수"+cnt);
    }

}
