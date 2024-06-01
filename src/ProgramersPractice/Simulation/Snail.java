package ProgramersPractice.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Snail {
    static int[][] arr;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        int num = 1;
        br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr=new int[n][n];
        int startRow=0,endRow=n-1;
        int startCol=0,endCol=n-1;

        while (startRow<=endRow && startCol<=endCol){
            //첫 행 채우기
            for (int i = startCol; i <= endCol; i++) {
                arr[startRow][i] = num++;
            }
            startRow++;

            //마지막 열 채우기
            for(int i=startRow;i<=endRow;i++){
                arr[i][endCol] = num++;
            }
            endCol--;

            //마지막 행 채우기
            for(int i=endCol;i>=startCol;i--){
                arr[endRow][i] = num++;
            }
            endRow--;

            //첫 열 채우기
            for(int i=endRow;i>=startRow;i--){
                arr[i][startCol] = num++;
            }
            startCol++;
        }
        for(int[] x : arr){
            System.out.print(Arrays.toString(x));
            System.out.println();
        }


    }
}
