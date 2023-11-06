package InflearnForBeginner.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximumIncomeSchedule {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt(), mDay;
    static ArrayList<Request> arr = new ArrayList<>();
    static PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    static int answer = 0;

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int day = sc.nextInt();
            arr.add(new Request(money, day));
        }
        Collections.sort(arr);
        mDay = arr.get(0).date;
        for (Request r : arr
        ) {
            System.out.println(r.money + " " + r.date);
        }
        int j = 0;
        for (int i = mDay; i >= 1; i--) {
            System.out.println(i + "일차");
            for (; j < n; j++) {
                System.out.println("j= "+j);
                if (arr.get(j).date < i) break;
                pQ.add(arr.get(j).money);
            }
            if (!pQ.isEmpty()) {
                int p = pQ.poll();
                System.out.println("p= "+p);
                answer += p;
            }
        }
        System.out.println(answer);

    }

    static class Request implements Comparable<Request> {
        int money;
        int date;

        public Request(int money, int day) {
            this.money = money;
            this.date = day;
        }

        @Override
        public int compareTo(Request o) {
            return o.date - this.date;
        }
    }
}
