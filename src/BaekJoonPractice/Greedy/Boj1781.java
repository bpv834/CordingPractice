package BaekJoonPractice.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Questions> arrayList = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int MaxLine=0;
        int answer=0;
        for (int i = 0; i < n; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int Dl = Integer.parseInt(tk.nextToken());
            int Score = Integer.parseInt(tk.nextToken());

            arrayList.add(new Questions(Dl, Score));
        }
        Collections.sort(arrayList);
        MaxLine = arrayList.get(0).Dl;

        int j=0;
        for (int i = MaxLine; i > 0; i--) {
            System.out.println(i+"일차");

            for (; j < n; j++) {
                if(arrayList.get(j).Dl <i) {
                    System.out.println("i= "+i+" j= "+j);
                    System.out.println(arrayList.get(j).Dl+" "+arrayList.get(j).Score);
                    break;
                }
                pq.add(arrayList.get(j).Score);
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }

    static class Questions implements Comparable<Questions> {
        int Dl;
        int Score;

        public Questions(int dl, int score) {
            Dl = dl;
            Score = score;
        }

        @Override
        public int compareTo(Questions o) {
            return o.Dl - this.Dl;
        }
    }
}
