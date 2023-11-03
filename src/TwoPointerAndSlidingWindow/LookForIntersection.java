package TwoPointerAndSlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class LookForIntersection {
    static Scanner sc = new Scanner(System.in);

    private static void lfi(int n, int arr1[], int m, int arr2[]) {
        /*1 2 4 5
            2 5 7 8 9*/
        String annswer = "";
        int p1=0,p2=0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] == arr2[p2]) {
                annswer+=" "+arr1[p1];
                p1++;
                p2++;
            } else if (arr1[p1]<arr2[p2]) {
                p1++;
            }
            else {
                p2++;
            }
        }
        System.out.println(annswer.substring(1));


    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int arr1[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int arr2[] = new int[m];
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        lfi(n, arr1, m, arr2);
    }
}
