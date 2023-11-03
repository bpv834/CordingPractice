package SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class CountiongDevideSearching {
    static Scanner sc = new Scanner(System.in);
    private static void cds(int []arr,int k) {
        Arrays.sort(arr);
        int lt = 0, rt = arr.length;
        int hl=0;
        while (true) {
            hl=(lt+rt)/2;
            if (arr[hl] == k) {
                System.out.println(++hl);
                break;
            }
            else if (k<arr[hl]) {
                //k가 중앙값보다 작을 때
                rt=hl;

            }
            else {
                //k가 중앙값보다 클 때
                lt = hl;
            }
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        cds(arr, k);
    }
}
