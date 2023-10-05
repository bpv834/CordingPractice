import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    static ArrayList<Point> hm = new ArrayList<>();
    static ArrayList<Point> pz = new ArrayList<>();
    static ArrayList<Point> result = new ArrayList<>();
    static int map[][] = new int[n + 1][n + 1];
    static int realDist = Integer.MAX_VALUE;


    static void com(int L, int s) {
        if (L == m) {
            int real = Search(0);
            realDist = Math.min(real, realDist);
        } else {
            for (int i = s; i < pz.size(); i++) {
                result.add(L, pz.get(i));
                com(L + 1, i + 1);
            }
        }
    }

    static int Search(int sum) {
        for (int i = 0; i < hm.size(); i++) {
            int answer = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int dist = Math.abs(hm.get(i).x - result.get(j).x) + Math.abs(hm.get(i).y - result.get(j).y);
                answer = Math.min(answer, dist);
            }
            sum += answer;
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    hm.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    pz.add(new Point(i, j));
                }
            }
        }
        com(0, 0);
        System.out.println(realDist);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
