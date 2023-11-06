package InflearnForBeginner.TwoPointerAndSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SumTwoArray {
    static Scanner sc = new Scanner(System.in);

    private static void sta(int arr1[], int arr2[]) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int p1=0;
        int p2=0;

        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] < arr2[p2]) {
                arrayList.add(arr1[p1++]);
            } else {
                arrayList.add(arr2[p2++]);
            }
        }

        while (p1 < arr1.length) {
            arrayList.add(arr1[p1++]);
        }
        while (p2 < arr2.length) {
            arrayList.add(arr2[p2++]);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i)+" ");
        }

    }

    public static void main(String[] args) {
       int n=sc.nextInt();
        int arr1[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i]=sc.nextInt();
        }
        int m = sc.nextInt();
        int arr2[] = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        sta(arr1, arr2);
    }
}
