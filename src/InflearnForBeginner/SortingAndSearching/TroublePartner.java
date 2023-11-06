package InflearnForBeginner.SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class TroublePartner {
    static Scanner sc = new Scanner(System.in);

    private static void tp(int n,int arr[]) {
        String answer = "";
        int tmp[] = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i];
        }
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) {
                answer += (i + 1)+" ";
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        tp(n, arr);
    }
}
