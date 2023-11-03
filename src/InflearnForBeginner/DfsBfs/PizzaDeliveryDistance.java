package InflearnForBeginner.DfsBfs;

import java.util.ArrayList;
import java.util.Scanner;

public class PizzaDeliveryDistance {
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
            System.out.print(result.get(0).x + " " + result.get(0).y + " ");
            System.out.print(result.get(1).x + " " + result.get(1).y + " ");
            System.out.print(result.get(2).x + " " + result.get(2).y + " ");
            System.out.println(result.get(3).x + " " + result.get(3).y + " ");
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
        for (int i = 0; i <  hm.size(); i++) {
            int answer = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                System.out.println("hmPoint= "+hm.get(i).x+" "+hm.get(i).y+"/resultPoint= "+result.get(j).x+" "+result.get(j).y);
                int dist = Math.abs(hm.get(i).x - result.get(j).x) + Math.abs(hm.get(i).y - result.get(j).y);
                System.out.println(dist);
                answer = Math.min(answer, dist);
            }

            System.out.println("answer= "+answer);
            sum += answer;
            System.out.println("sum= "+sum);
            System.out.println("M끝");
        }
        System.out.println("realSum= "+sum);
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
