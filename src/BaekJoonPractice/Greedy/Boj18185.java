package BaekJoonPractice.Greedy;

import java.util.Scanner;

public class Boj18185 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        int factory[] = new int[n + 2];
        for (int i = 0; i < n; i++) {
            factory[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            // i+1이 i+2보다 큰경우 그렇지 않도록 작업을 해주고 나서 7점짜리를 계산한다.
            if (factory[i + 1] > factory[i + 2]) {
                int tmp = Math.min(factory[i + 1] - factory[i + 2], factory[i]);
                answer += 5 * tmp;
                factory[i] -= tmp;
                factory[i + 1] -= tmp;
                System.out.println("1. tmp= " + tmp + " fac[i]= " + factory[i] + " fac[i+1]= " + factory[i + 1] + " fac[i+2]= " + factory[i + 2] + " answer= " + answer);
            }

            int tmp = Math.min(factory[i], Math.min(factory[i + 1], factory[i + 2]));
            answer += tmp * 7;
            factory[i] -= tmp;
            factory[i + 1] -= tmp;
            factory[i + 2] -= tmp;
            System.out.println("2. tmp= " + tmp + " fac[i]= " + factory[i] + " fac[i+1]= " + factory[i + 1] + " fac[i+2]= " + factory[i + 2] + " answer= " + answer);


            answer += 3 * factory[i];
            factory[i] = 0;
            System.out.println("3. fac[i]= " + factory[i] + " fac[i+1]= " + factory[i + 1] + " fac[i+2]= " + factory[i + 2]);
        }
        System.out.println(answer);
    }
}