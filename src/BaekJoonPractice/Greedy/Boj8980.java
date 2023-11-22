package BaekJoonPractice.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj8980 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String nAndWeight = br.readLine();
            StringTokenizer tk = new StringTokenizer(nAndWeight);
            int n = Integer.parseInt(tk.nextToken());
            int maxWeight = Integer.parseInt(tk.nextToken());
            int m = Integer.parseInt(br.readLine());
            int currentWeight = 0;
            int ansWeight = 0;
            ArrayList<PostInfo> pi = new ArrayList<>();
            int to[] = new int[n];
            Arrays.fill(to, maxWeight);

            for (int i = 0; i < m; i++) {
                String content = br.readLine();
                StringTokenizer stringTokenizer = new StringTokenizer(content);

                int sendTown = Integer.parseInt(stringTokenizer.nextToken());
                int receiveTown = Integer.parseInt(stringTokenizer.nextToken());
                int weight = Integer.parseInt(stringTokenizer.nextToken());

                pi.add(new PostInfo(sendTown, receiveTown, weight));
            }
            Collections.sort(pi);

            for (PostInfo p:pi
            ) {
                System.out.println(p.sendNum+" "+p.receiveNum+" "+p.weight);
            }

            for (int i = 0; i < m; i++) {

                int send = pi.get(i).sendNum;
                int receive = pi.get(i).receiveNum;
                int weight = pi.get(i).weight;
                int minWeight = Integer.MAX_VALUE;
                System.out.println(send+" "+receive);

                for (int j = send; j < receive; j++) {
                    minWeight = Math.min(minWeight, to[j]);
                }

                if (weight <= minWeight) {
                    to[send] -= weight;
                    ansWeight += weight;
                    System.out.println(Arrays.toString(to));
                } else{
                    for (int j = send; j < receive; j++) {
                        to[j] -= minWeight;
                    }
                    ansWeight += minWeight;
                }

            }

            System.out.println(ansWeight);
    }
    static class PostInfo implements Comparable<PostInfo>{
        int sendNum;
        int receiveNum;
        int weight;

        public PostInfo(int sendNum, int receiveNum, int weight) {
            this.sendNum = sendNum;
            this.receiveNum = receiveNum;
            this.weight = weight;
        }

        @Override
        public int compareTo(PostInfo o) {
            if(this.receiveNum==o.receiveNum) return this.sendNum - o.sendNum;
            return this.receiveNum-o.receiveNum;
        }
    }
}
