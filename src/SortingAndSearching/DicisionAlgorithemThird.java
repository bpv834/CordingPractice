package SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class DicisionAlgorithemThird {
    static Scanner sc = new Scanner(System.in);

    private static int pcount(int arr[], int c, int cp) {
        int answer=1;
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - tmp >= cp) {
                ++answer;
                tmp=arr[i];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int value=0;
        int n = sc.nextInt();
        int c = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[arr.length - 1];


        while (lt <= rt) {
         System.out.println("lt=" + lt + " rt= " + rt);
          int cp = (rt + lt) / 2;
               if (pcount(arr, c, cp) >= c) {
                   value=cp;
                lt=cp+1;
               }
               else{
                   rt=cp-1;
               }
            }
        System.out.println(value);
    }
}
