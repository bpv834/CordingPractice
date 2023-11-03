package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StackingStoneTowers {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static ArrayList<Info> arrayList = new ArrayList<>();
    static int dy[] = new int[n];

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            int area = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            arrayList.add(new Info(area, height, weight));
        }
        Collections.sort(arrayList);
        dy[0]=arrayList.get(0).height;
        for (int i = 1; i < n; i++) {
            int max=0;
            for (int j = i - 1; j >= 0; j--) {
                if (arrayList.get(i).area > arrayList.get(j).area && arrayList.get(i).weight > arrayList.get(j).weight && dy[j]>max) {
                    max=dy[j];
                }
            }
            dy[i]=max+arrayList.get(i).height;
        }
        int answer=0;
        for (int x:dy
             ) {
            answer=Math.max(answer,x);
        }
        System.out.println(answer);

    }
    static class Info implements Comparable<Info>{
        int area;
        int height;
        int weight;

        public Info(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            return this.area-o.area;
        }
    }
}
