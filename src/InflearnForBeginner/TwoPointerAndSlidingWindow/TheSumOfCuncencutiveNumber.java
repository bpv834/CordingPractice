package InflearnForBeginner.TwoPointerAndSlidingWindow;

import java.util.Scanner;

public class TheSumOfCuncencutiveNumber {
    static Scanner sc = new Scanner(System.in);

    private static void tsocn(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=i+1;
        }
        /*  1 2 3 4 5 6 7 8 9*/
        int p1=0,p2=0;
        int answer=0;
        int value=0;
        int cnt=0;
        while (p2 < n) {
            if (value >= n) {
                value = value - arr[p1++];
                System.out.println("1value= "+value+" p1= "+p1+" p2= "+p2+" cnt= "+cnt);
            }
            if(value<n) {
                value += arr[p2++];
                System.out.println("2value= "+value+" p1= "+p1+" p2= "+p2+" cnt= "+cnt);
            }
            if (value == n) {
                cnt++;
                value += arr[p2++];
                System.out.println("3value= "+value+" p1= "+p1+" p2= "+p2+" cnt= "+cnt);

            }


        }
        System.out.println(cnt);

    }

    /*1 2 3 4 5 6 7 8 9 10 11 */
    public static void main(String[] args) {
        tsocn(sc.nextInt());
    }
}
