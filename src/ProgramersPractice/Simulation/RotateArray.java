package ProgramersPractice.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArray {
    static BufferedReader br;
    static int array[][];

    static int[][] rotate90(int arr[][]) {
        int[][] rotateArr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int row = 4 - 1 - i;
                rotateArr[j][row] = arr[i][j];
            }
        }
        return rotateArr;
    }

    static void rotateN(int[][] arr, int n) {
        System.out.println(arr[0][0]);
        for (int i = 0; i < n; i++) {
            arr = rotate90(arr);
            System.out.println(arr[0][0]);
        }
        array = arr;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int curArr[][] = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotateN(curArr, n);

    }
}
