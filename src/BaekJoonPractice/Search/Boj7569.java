package BaekJoonPractice.Search;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569 {
    static BufferedReader br;
    static int dCol[] = new int[]{0, 0, -1, 1, 0, 0};
    static int dRow[] = new int[]{0, 0, 0, 0, -1, 1};
    static int dHeight[] = new int[]{-1, 1, 0, 0, 0, 0};
    static int n, m, h;
    static int tomatoes[][][];
    static int dis[][][];
    static Queue<Point3D> q;
    static int ans = Integer.MIN_VALUE;
    static Boolean flag = true;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer tk = new StringTokenizer(str);
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        h = Integer.parseInt(tk.nextToken());

        tomatoes = new int[h + 1][m + 1][n + 1];
        dis = new int[h + 1][m + 1][n + 1];
        q = new LinkedList<>();

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= m; j++) {
                String col = br.readLine();
                tk = new StringTokenizer(col);
                for (int k = 1; k <= n; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(tk.nextToken());
                    if (tomatoes[i][j][k] == 1) {
                        q.add(new Point3D(i, j, k));
                    }
                }
            }
        }
        Bfs();
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    System.out.print(dis[i][j][k] + " ");
                }
                System.out.println();
            }
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        flag = false;
                        break;
                    }
                    ans = Math.max(dis[i][j][k], ans);
                }
            }
        }
        if (flag) System.out.println(ans);
        else System.out.println(-1);


    }

    static void Bfs() {
        while (!q.isEmpty()) {
            Point3D tmp = q.poll();
            int nowHeight = tmp.cHeight;
            int nowCol = tmp.cCol;
            int nowRow = tmp.cRow;

            for (int i = 0; i < 6; i++) {
                int nHeight = nowHeight + dHeight[i];
                int nCol = nowCol + dCol[i];
                int nRow = nowRow + dRow[i];

                if (nCol >= 1 && nCol <= m && nRow >= 1 && nRow <= n && nHeight >= 1 && nHeight <= h && tomatoes[nHeight][nCol][nRow] == 0) {
                    System.out.println("nH= "+nowHeight+" nC="+nowCol+" nR= "+nowRow);
                    tomatoes[nHeight][nCol][nRow] = 1;
                    dis[nHeight][nCol][nRow] =dis[nowHeight][nowCol][nowRow] + 1;
                    q.add(new Point3D(nHeight, nCol, nRow));
                }
            }
        }
    }

    static class Point3D {
        int cHeight;
        int cCol;
        int cRow;


        public Point3D(int cHeight, int cCol, int cRow) {
            this.cHeight = cHeight;
            this.cCol = cCol;
            this.cRow = cRow;
        }
    }
}
