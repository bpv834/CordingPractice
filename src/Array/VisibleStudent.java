package Array;

import java.util.Arrays;
import java.util.Scanner;

public class VisibleStudent {
    static Scanner sc = new Scanner(System.in);
    private static void vs(int n) {
        int cnt=0;
        int max=0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num > max) {
                max=num;
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        vs(sc.nextInt());
    }
}
