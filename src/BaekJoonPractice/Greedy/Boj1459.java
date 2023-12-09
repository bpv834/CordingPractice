package BaekJoonPractice.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer tk = new StringTokenizer(str);
        long x = Long.parseLong(tk.nextToken());
        long y = Long.parseLong(tk.nextToken());
        long w = Long.parseLong(tk.nextToken());
        long s = Long.parseLong(tk.nextToken());
        long tmp = 0;
        long ans = 0;
        if (x > y) {
            //x가 작은값으로 세팅
            tmp = x;
            x = y;
            y = tmp;
        }

        if (2 * w > 2 * s) {
            ans = x * s;
            long lw = y - x;
            if (lw % 2 == 0) {
                ans += lw * s;
            } else {
                ans += (lw - 1) * s;
                ans += w;
            }

        } else if (2 * w > s) {
            long lw = y - x;
            ans = x * s;
            ans += (lw * w);
        } else {
            ans = w * (x + y);
        }
         System.out.println(ans);

    }
}
