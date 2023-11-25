package BaekJoonPractice.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int l = Integer.parseInt(tk.nextToken());
        ArrayList<Sandload> arrayList = new ArrayList<>();
        int ans = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            tk = new StringTokenizer(str);
            int st = Integer.parseInt(tk.nextToken());
            int fi = Integer.parseInt(tk.nextToken());
            arrayList.add(new Sandload(st, fi));
        }

        Collections.sort(arrayList);


        for (Sandload ob : arrayList
        ) {


            int st = ob.st;
            int fi = ob.fi;
            if (st <= end) {
                st = end + 1;
                System.out.println("st값이 변경됨");
            }
            System.out.println("st= " + st + " fi= " + fi);
            int gap = fi - st;
            if (gap > 0) {
                if ((gap) % l == 0) {
                    ans += gap / l;
                    end = st + l * (gap / l) - 1;
                    System.out.println("ㅇㅇㅇㅇans= " + ans + " end= " + end);
                } else {
                    int cnt = gap / l + 1;
                    ans += gap / l + 1;
                    end = (st + l * cnt) - 1;
                    System.out.println("ㅋㅋㅋㅋㅋans= " + ans + " end= " + end);
                }
            }

        }
        System.out.println(ans);
    }

    static class Sandload implements Comparable<Sandload> {
        int st;
        int fi;

        public Sandload(int st, int fi) {
            this.st = st;
            this.fi = fi;
        }

        @Override
        public int compareTo(Sandload o) {
            return this.st - o.st;
        }
    }
}
