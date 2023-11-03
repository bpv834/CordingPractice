package SortingAndSearching;

import java.util.Scanner;

public class SortingForBubble {
    static Scanner sc = new Scanner(System.in);

    private static void sfb(int arr[]) {
        String answer = "";
        int l = arr.length; //6
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l - i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1]=tmp;
                }
            }
        }
        for (int x:arr
             ) {answer+=x+" ";
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        int arr[] = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sfb(arr);
    }
}
