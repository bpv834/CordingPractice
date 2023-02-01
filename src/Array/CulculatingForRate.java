package Array;

import java.util.Arrays;
import java.util.Scanner;

public class CulculatingForRate {
    static Scanner sc = new Scanner(System.in);

    private static void cf(int n) {
        int arr[] = new int[n];
        int result[] = new int[n];
        int rate=1;
        int cnt=0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }

        for (int i = 0; i < n; i++) {
            cnt=0;
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    cnt++;
                }
            }
            result[i]=rate+cnt;

        }
        System.out.println(Arrays.toString(result));


    }

    public static void main(String[] args) {
        cf(sc.nextInt());
    }
}
