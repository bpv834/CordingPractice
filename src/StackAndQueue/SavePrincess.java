package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavePrincess {
    static Scanner sc = new Scanner(System.in);

    private static int sp(int m, int k) {
        Queue<Integer> Q=new LinkedList();
        int answer=0;
        for (int i = 1; i <= m; i++) {
            Q.offer(i);
        }

        while (!Q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                Q.offer(Q.poll());
            }
            Q.poll();
            if (Q.size() == 1) {
                answer = Q.poll();
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(sp(sc.nextInt(),sc.nextInt()));
    }
}
