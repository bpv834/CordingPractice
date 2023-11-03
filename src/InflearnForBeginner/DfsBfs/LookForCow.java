package InflearnForBeginner.DfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LookForCow {
    static Scanner sc = new Scanner(System.in);

    private static int lfc(int l,int r) {
        Queue<Integer> q = new LinkedList<>();
        int check[]=new int[100001];
        int dis[] = {1, -1, 5};
        int answer=0;
        int L=0;
        q.offer(l);
        check[l]=1;
        while (!q.isEmpty()) {
            int len=q.size();
            for (int i = 0; i < len; i++) {
                int x=q.poll();
                if (x == r) {
                    answer=L;
                    break;
                }
                for (int j = 0; j < 3; j++) {
                    int nx=x+dis[j];
                    if (nx > 0 && nx < 10001 && check[nx] == 0) {
                        check[nx]=1;
                        q.offer(nx);

                    }
                }

            }

            L++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int l = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(lfc(l, r));
    }
}
