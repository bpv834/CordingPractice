package BaekJoonPractice.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1697 {
    static BufferedReader br;
    static int n, k;
    static int ans = Integer.MAX_VALUE;
    static Queue<queueLevel> q;
    static Boolean[] ch;

    public static void main(String[] args) throws IOException {
        q = new LinkedList<>();
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer tk = new StringTokenizer(str);
        n = Integer.parseInt(tk.nextToken());
        k = Integer.parseInt(tk.nextToken());
        ch = new Boolean[100001];
        Arrays.fill(ch,false);
        Bfs();

    }

    private static void Bfs() {
        q.add(new queueLevel(n, 0));
        ch[n] = true;
        while (!q.isEmpty()) {
            queueLevel tmp = q.poll();
            int nowValue = tmp.value;
            int nowLevel = tmp.level;
            if (nowValue == k) {
                ans = Math.min(ans, nowLevel);
                break;
            } else {
                if (nowValue - 1 >= 0 && !ch[nowValue - 1]) {
                    q.add(new queueLevel(nowValue - 1, nowLevel + 1));
                    ch[nowValue - 1] = true;
                }
                if (nowValue + 1 <= 100000 && !ch[nowValue + 1]) {
                    q.add(new queueLevel(nowValue + 1, nowLevel + 1));
                    ch[nowValue + 1] = true;
                }
                if (nowValue * 2 <= 100000 && !ch[nowValue * 2]) {
                    q.add(new queueLevel(nowValue * 2, nowLevel + 1));
                    ch[nowValue * 2] = true;
                }
            }
        }
        System.out.println(ans);
    }

    static class queueLevel {
        int value;
        int level;

        public queueLevel(int value, int level) {
            this.value = value;
            this.level = level;
        }
    }
}
