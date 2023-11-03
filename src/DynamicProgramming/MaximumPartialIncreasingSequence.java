package DynamicProgramming;

import java.util.Scanner;

public class MaximumPartialIncreasingSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int arr[] = new int[n];
        int dy[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dy[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
        }

        for (int len : dy) {
            answer = Math.max(answer, len);
        }
        System.out.println(answer);
    }
}
