package InflearnForBeginner.SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class ConfirmOverlapNumber {
    static Scanner sc = new Scanner(System.in);

    private static void col(int arr[]) {
        Arrays.sort(arr);
        boolean checked = true;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i + 1]) {
                checked = false;
                break;
            }
        }
        if (arr[arr.length - 1] == arr[arr.length - 2]) {
            checked = false;
        }
        if (checked == true) {
            System.out.println("U");
        } else {
            System.out.println("D");
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        col(arr);
    }
}
