package InflearnForBeginner.SortingAndSearching;

import java.util.Scanner;

public class SortingForSelect {
    static Scanner sc = new Scanner(System.in);

    private static void sfs(int arr[]) {
        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int idx=i;
                if (arr[j] < arr[idx]) {
                    idx=j;
                }
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx]=tmp;
            }
        }
        for (int x:arr
             ) {
            answer += x+" ";
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sfs(arr);
    }
}
