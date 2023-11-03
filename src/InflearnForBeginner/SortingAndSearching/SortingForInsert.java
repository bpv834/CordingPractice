package InflearnForBeginner.SortingAndSearching;

import java.util.Scanner;

public class SortingForInsert {
    static Scanner sc = new Scanner(System.in);

    private static void sfi(int arr[]) {
        String answer = "";
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j+1]) {

                    arr[j+1]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        for (int x:arr
             ) {
            answer+=x+" ";
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        int arr[] = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sfi(arr);
    }
}
