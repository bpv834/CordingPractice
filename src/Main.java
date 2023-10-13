import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
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
        int j = 0;
        for (int i = mDay; i >= 1; i--) {
            for (; j < n; j++) {
                if (arr.get(j).date < i) break;
                pQ.add(arr.get(j).money);
            }
            if (!pQ.isEmpty()) {
                int p = pQ.poll();
                answer += p;
            }
        }
        System.out.println(answer);
    }

    static class Request implements Comparable<Request> {
        int money;
        int date;

        public Request(int money, int date) {
            this.money = money;
            this.date = date;
        }

        @Override
        public int compareTo(Request o) {
            return o.date - this.date;
        }
    }
}
