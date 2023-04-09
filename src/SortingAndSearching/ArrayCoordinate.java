package SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ArrayCoordinate {
    static Scanner sc = new Scanner(System.in);

    private static void ac(int n,int arr[][]) {

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        for (int i = 0; i < n; i++) {
            String answer = "";
            for (int j = 0; j < 2; j++) {
                answer+= arr[i][j]+" ";
            }
            answer=answer.substring(0,answer.length()-1);
            System.out.println(answer);
        }
    }


    public static void main(String[] args) {
        int n = sc.nextInt();
        int arr[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        ac(n, arr);

    }
}

