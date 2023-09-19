package DfsBfs;

import java.util.Scanner;

public class MazeSearch {
    static int vertical[] = new int[]{-1, 1, 0, 0};
    static int horizon[] = new int[]{0, 0, -1, 1};
    static Scanner sc = new Scanner(System.in);
    static int maze[][] = new int[8][8];
    static int ch[][] = new int[8][8];
    static int cnt = 0;

    static void Dfs(int x, int y) {
        ch[x][y]=1;
        if (x == 7 & y == 7) {
            System.out.println("도착 :" + x + " " + y);
            cnt++;
        } else {
            for (int i = 0; i < 4; i++) {
                System.out.println("출발: " + x + " " + y);
                int v = x + vertical[i];
                int h = y + horizon[i];
                if (v>0 && h>0 && v<8 && h<8) {
                    System.out.println(v + " " + h);
                    if (maze[v][h] == 0 && ch[v][h] == 0) {
                        Dfs(v, h);
                        ch[v][h] = 0;
                    }
                }else {
                    System.out.println("꽝 "+v+" "+h);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        Dfs(1, 1);
        System.out.println(cnt);
    }
}