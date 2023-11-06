package InflearnForBeginner.Array;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumGrid {
    static Scanner sc = new Scanner(System.in);

    private static void msg(int n) {
        int arr[][] = new int[n][n];
        int result[] = new int[4];
        int colmax=0;
        int rowmax=0;
        int colvalue=0;
        int rowvalue=0;
        int updiagonal=0;
        int downdiagonal=0;
        int answer=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("행 포문 동작 시작");
        //행 최대값 출력
        for (int i = 0; i < n; i++) {
            colvalue=0;
            rowvalue=0;
            for (int j = 0; j < n; j++) {
               colvalue=arr[i][j]+colvalue;
                rowvalue=arr[j][i]+rowvalue;
                if (i == j) {
                    downdiagonal += arr[i][j];
                }
                if (i + j == n - 1) {
                    updiagonal += arr[i][j];
                }
            }
            if(colvalue>colmax)
                colmax=colvalue;
            if(rowvalue>rowmax)
                rowmax=rowvalue;
            result[0]=colmax;
            result[1]=rowmax;
            result[2]=downdiagonal;
            result[3]=updiagonal;
        }
        Arrays.sort(result);
        System.out.println(result[result.length-1]);
        //열 최대값 출력



    }

    public static void main(String[] args) {
        msg(sc.nextInt());
    }
}
